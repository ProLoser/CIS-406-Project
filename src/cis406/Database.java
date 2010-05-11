package cis406;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 * A database wrapping class. Either call the static methods for direct access
 * to the database, or initialize an instance of the class and build your query
 * piece by piece.
 *
 * @author Dean Sofer
 */
public class Database {

    // CONFIGURATION OPTIONS
    private static final String dbHost = "localhost";
    private static final String dbUsername = "";
    private static final String dbPassword = "";
    private static final String dbDatabase = "internshipsdb";
    private static final String dbType = "derby"; // mysql
    // DO NOT EDIT BELOW THIS POINT!!!
    private String table = "";
    private String joins = "";
    private Map<String, Object> andConditions;
    private Map<String, Object> orConditions;
    private Map<String, Object> fields;
    private List<String> orderBys;
    private int limit = 0;
    private List<Object> preValues = null;
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preStatement = null;
    private static ResultSet resultSet = null;

    /**
     * Build a custom query object
     */
    public Database() {
        fields = new HashMap<String, Object>();
        orConditions = new HashMap<String, Object>();
        andConditions = new HashMap<String, Object>();
    }

    /**
     * Build a custom query object with the mian query table set
     * @param table
     */
    public Database(String table) {
        this.table = table;
        fields = new HashMap<String, Object>();
        orConditions = new HashMap<String, Object>();
        andConditions = new HashMap<String, Object>();
    }

    /**
     * Sets the table the query will be run on
     * @param table
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * Retrieves the table the query will be run on
     * @return
     */
    public String getTable() {
        return table;
    }

    /**
     * Sets the fieldsAffected limit for update/delete/select
     * @param limit int
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Returns the currently set fieldsAffected limit for update/delete/select
     * @return limit int
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Adds a field/value pair to the array of fields to be stored
     *
     * @param field
     * @param value
     */
    public void addField(String field, Object value) {
        fields.put(field, value);
    }

    /**
     * Removes the field from the array of fields to be stored
     *
     * @param field
     */
    public void removeField(String field) {
        fields.remove(field);
    }

    /**
     * Returns the value to be stored of the field
     *
     * @param field
     * @return
     */
    public Object getField(String field) {
        return fields.get(field);
    }

    /**
     * Returns the current build of the query for use with a PreparedStatement
     * Requires compilePreValues() to be run before executing query
     *
     * @return the value of query
     */
    private String compileConditions() {
        String conditions = " WHERE 1=1 ";
        if (andConditions != null) {
            for (Map.Entry<String, Object> cond : andConditions.entrySet()) {
                conditions += " AND " + cond.getKey() + " = ?";
                preValues.add(cond.getValue());
            }
        }
        if (orConditions != null) {
            for (Map.Entry<String, Object> cond : orConditions.entrySet()) {
                conditions += " OR " + cond.getKey() + " = ?";
                preValues.add(cond.getValue());
            }
        }
        if (orderBys != null) {
            conditions += " ORDER BY ";
            conditions += implode((String[]) orderBys.toArray());
        }
        if (limit > 0) {
            conditions += " LIMIT " + limit;
        }

        return conditions;
    }

    /**
     * Inserts all the preValues into the PreparedStatement query before execution
     * @throws Exception
     */
    private void compilePreValues() {
        int i = 0;
        
        try {
            for (i = 0; i < preValues.size(); i++) {
                //System.out.println(preValues.get(i));
                preStatement.setObject(i+1, preValues.get(i));
            }
        } catch (Exception e) {
            System.out.println("Failed to set slot [" + (i+1) + "] to \"" + preValues.get(i) + "\"");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Add an 'or' condition to the query object
     *
     * @param field
     * @param value
     */
    public void or(String field, Object value) {
        orConditions.put(field, value);
    }

    /**
     * Add an 'and' condition to the query object
     *
     * @param field
     * @param value
     */
    public void and(String field, Object value) {
        andConditions.put(field, value);
    }

    /**
     * The INNER JOIN keyword return rows when there is at least one match in both tables.
     *
     * @param joinTable
     * @param foreignKey
     */
    public void inner(String joinTable, String foreignKey) {
        joins += " INNER JOIN " + joinTable;
        join(joinTable, foreignKey);
    }

    /**
     * The LEFT JOIN keyword returns all rows from the left table (table_name1),
     * even if there are no matches in the right table (table_name2).
     *
     * @param joinTable
     * @param foreignKey
     */
    public void left(String joinTable, String foreignKey) {
        joins += " LEFT JOIN " + joinTable;
        join(joinTable, foreignKey);
    }

    /**
     * The RIGHT JOIN keyword Return all rows from the right table (table_name2),
     * even if there are no matches in the left table (table_name1).
     *
     * @param joinTable
     * @param foreignKey
     */
    public void right(String joinTable, String foreignKey) {
        joins += " RIGHT JOIN " + joinTable;
        join(joinTable, foreignKey);
    }

    /**
     * The FULL JOIN keyword return rows when there is a match in one of the tables.
     *
     * @param joinTable
     * @param foreignKey
     */
    public void full(String joinTable, String foreignKey) {
        joins += " FULL JOIN " + joinTable;
        join(joinTable, foreignKey);
    }

    /**
     * Returns the merger of two tables
     *
     * @param joinTable
     * @param foreignKey
     */
    private String join(String joinTable, String foreignKey) {
        String query;
        query = " ON " + table + "." + id(table) + "=" + joinTable + "." + foreignKey;
        return query;
    }

    /**
     * The SELECT statement is used to select data from a database.
     * @return
     */
    public ResultSet select() throws Exception {
        String query = "SELECT * FROM " + table + " " + joins + " " + compileConditions();
        preStatement = connect().prepareStatement(query);
        compilePreValues();
        return execute(query);
    }

    /**
     * The SELECT statement is used to select data from a database.
     * @param fields columns to retrieve
     */
    public ResultSet select(String[] fields) throws Exception {
        String query;
        preValues = new ArrayList<Object>();
        query = "SELECT " + implode(fields) + " FROM " + table + joins + compileConditions();
        return execute(query);
    }

    /**
     * Compiles and executes an INSERT query.
     *
     * @param fields values to be updated
     * @return ResultSet of the newly created primary keys
     */
    public int insert() throws Exception {
        String query = "INSERT INTO " + table;
        preValues = new ArrayList<Object>();
        String keys = "";
        String values = "";
        Boolean first = true;

        for (Map.Entry<String, Object> field : fields.entrySet()) {
            if (!first) {
                keys += ", ";
                values += ", ";
            }
            keys += field.getKey();
            values += "?";
            preValues.add(field.getValue());
            first = false;
        }
        query += " (" + keys + ") VALUES (" + values + ")";

        System.out.println("Query: " + query);
        preStatement = connect().prepareStatement(query);
        compilePreValues();
        preStatement.executeUpdate();
        return preStatement.getGeneratedKeys().getInt(id(table));
    }

    /**
     * Compiles and executes an UPDATE query. Returns the number of records affected
     *
     * @param fields values to be updated
     * @return recordsAffected int
     */
    public int update() throws Exception {
        String query = "UPDATE " + table + " SET ";
        Boolean first = true;
        preValues = new ArrayList<Object>();
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            if (!first) {
                query += ", ";
            }
            query += field.getKey() + " = ?";
            preValues.add(field.getValue());
            first = false;
        }
        query += compileConditions();
        System.out.println("Query: " + query);
        preStatement = connect().prepareStatement(query);
        compilePreValues();
        return preStatement.executeUpdate();
    }

    /**
     * Compiles the and executes a DELETE query. Returns the number of records affected
     *
     * @return recordsAffected int
     */
    public int delete() throws Exception {
        String query = "DELETE FROM " + table + compileConditions();
        preValues = new ArrayList<Object>();
        System.out.println("Query: " + query);
        preStatement = connect().prepareStatement(query);
        compilePreValues();
        return preStatement.executeUpdate();
    }

    /////////////STATIC METHODS/////////////////
    /**
     * Selects all records from the table
     * @param table
     * @return
     */
    public static ResultSet read(String table) {
        String query;
        query = "SELECT * FROM " + table;
        return execute(query);
    }

    /**
     * Find by ID. Pass the primary id to read the related record
     *
     * @param table Name of the table to query
     * @param id The primary key id of the record to pull
     * @return ResultSet
     */
    public static ResultSet read(String table, int id) {
        String query;
        query = "SELECT * FROM " + table + " WHERE " + id(table) + "=" + id;
        return execute(query);
    }

    /**
     * Delete a record from a table based on an id
     *
     * @param table
     * @param id
     * @return recordsAffected int
     */
    public static int delete(String table, int id) {
        String query = "";
        query = "DELETE FROM " + table + " WHERE " + id(table) + "=" + id;
        return executeWrite(query);
    }

    /**
     * Executes a raw sql query
     *
     * @param query new value of query
     * @return resultset
     */
    public static ResultSet execute(String query) {
        System.out.println("Query: " + query);

        try {
            connect();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Failed to query the database");
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    /**
     * Executes a raw sql query
     *
     * @param query new value of query
     * @return recordsAffected
     */
    public static int executeWrite(String query) {
        int recordsAffected = 0;
        System.out.println("Query: " + query);
        try {
            connect();
            statement = connect.createStatement();
            recordsAffected = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Failed to update the database");
            System.out.println(e.getMessage());
        }
        return recordsAffected;
    }

    /**
     * Returns an active connection object to be used and manipulated at the
     * developers will. MUST BE CLOSED BY THE DEVELOPER!
     *
     * @return connection
     */
    public static Connection connect() {
        if (connect == null) {
            try {
                //connect = DriverManager.getConnection("jdbc:" + dbType + "://" + dbHost + "/" + dbDatabase + "?user=" + dbUsername + "&password=" + dbPassword);
                connect = DriverManager.getConnection("jdbc:derby:internshipsdb");
            } catch (SQLException se) {
                System.out.println("Failed to connect: SQL Exception");
                for (Throwable t : se) {
                    t.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Failed to connect");
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }

    /**
     * Closes the static connection
     */
    public static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Failed to close the connection");
            System.out.println(e.getMessage());
        }
    }

    ////////////////// UTILITY FUNCTIONS //////////////////
    /**
     * Returns a string version of the primary_key from the table
     *
     * @param table
     * @return
     */
    public static String id(String table) {
        return table + "_id";
    }

    /**
     * Combines an array into a comma-deliminated string
     *
     * @param ary
     * @param delim
     * @return
     */
    public static String implode(String[] ary) {
        return implode(ary, ", ");
    }

    /**
     * Combines an array into a deliminator separated string
     * @param ary
     * @param delim
     * @return
     */
    public static String implode(String[] ary, String delim) {
        String out = "";
        for (int i = 0; i < ary.length; i++) {
            if (i != 0) {
                out += delim;
            }
            out += ary[i];
        }
        return out;
    }

}