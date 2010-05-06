package cis406;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

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
    private Map<String, String> andConditions;
    private Map<String, String> orConditions;
    private List<String> orderBys;
    private int limit = 0;
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    /**
     * Build a custom query object
     */
    public Database() {
    }

    /**
     * Build a custom query object with the table set
     * @param table
     */
    public Database(String table) {
        this.table = table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    /**
     * Returns the current build of the query
     *
     * @return the value of query
     */
    private String compileConditions() {
        Boolean first = true;
        String conditions = " WHERE 1=1 ";
        if (andConditions != null) {
            for (Map.Entry<String, String> cond : andConditions.entrySet()) {
                conditions += " AND ";
                conditions += cond.getKey() + " = " + e(cond.getValue());
            }
        }
        if (orConditions != null) {
            for (Map.Entry<String, String> cond : orConditions.entrySet()) {
                conditions += " OR ";
                conditions += cond.getKey() + " = " + e(cond.getValue());
            }
        }
        if (orderBys != null) {
            conditions += " ORDER BY ";
            for (String ob : orderBys) {
                if (!first) {
                    conditions += ", ";
                }
                conditions += ob;
                first = false;
            }
        }
        if (limit > 0) {
            conditions += " LIMIT " + limit;
        }

        return conditions;
    }

    /**
     * Add an 'or' condition to the query object
     *
     * @param field
     * @param value
     */
    public void or(String field, String value) {
        orConditions.put(field, value);
    }

    /**
     * Add an 'and' condition to the query object
     *
     * @param field
     * @param value
     */
    public void and(String field, String value) {
        andConditions.put(field, value);
    }

    /**
     * The INNER JOIN keyword return rows when there is at least one match in both tables.
     *
     * @param joinTable
     * @param foreignKey
     */
    public void inner(String joinTable, String foreignKey) {
        joins += " INNER JOIN " + t(joinTable);
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
        joins += " LEFT JOIN " + t(joinTable);
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
        joins += " RIGHT JOIN " + t(joinTable);
        join(joinTable, foreignKey);
    }

    /**
     * The FULL JOIN keyword return rows when there is a match in one of the tables.
     *
     * @param joinTable
     * @param foreignKey
     */
    public void full(String joinTable, String foreignKey) {
        joins += " FULL JOIN " + t(joinTable);
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
        query = " ON " + t(table + "." + id(table)) + "=" + t(joinTable + "." + foreignKey);
        return query;
    }

    /**
     * The SELECT statement is used to select data from a database.
     * @return
     */
    public ResultSet select() {
        String query;
        query = "SELECT * FROM " + t(table) + compileConditions();
        return execute(query);
    }

    /**
     * The SELECT statement is used to select data from a database.
     * @param fields columns to retrieve
     */
    public ResultSet select(String[] fields) {
        String query;
        Boolean first = true;
        query = "SELECT ";
        for (String field : fields) {
            if (!first) {
                query += ", ";
            }
            query += field;
            first = false;
        }
        query += " FROM " + t(table) + compileConditions();
        return execute(query);
    }

    /**
     * The UPDATE statement is used to update existing records in a table.
     *
     * @param fields values to be updated
     * @return recordsAffected int
     */
    public int update(Map<String, String> fields) {
        String query;
        Boolean first = true;
        query = "UPDATE " + t(table) + " SET ";
        for (Map.Entry<String, String> field : fields.entrySet()) {
            if (!first) {
                query += ", ";
            }
            query += field.getKey() + " = " + e(field.getValue());
            first = false;
        }
        query += compileConditions();
        return executeWrite(query);
    }

    /**
     * The DELETE statement is used to delete rows in a table.
     *
     * @return recordsAffected int
     */
    public int delete() {
        String query;
        query = "DELETE FROM " + t(table) + joins + compileConditions();
        return executeWrite(query);
    }


    /////////////STATIC METHODS/////////////////


    /**
     *
     * @param fields
     * @return
     */
    private static String buildConditions(Map<String, String> fields) {
        String query = " WHERE 1=1 ";
        for (Map.Entry<String, String> field : fields.entrySet()) {
            query += " AND ";
            query += t(field.getKey()) + "=" + e(field.getValue());
        }
        return query;
    }

    /**
     *
     * @param table
     * @return
     */
    public static ResultSet read(String table) {
        String query;
        query = "SELECT * FROM " + t(table);
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
        query = "SELECT * FROM " + t(table) + " WHERE " + id(table) + "=" + id;
        return execute(query);
    }

    /**
     * Read specific fields based on conditions. Pass a Map of fields you wish
     * to pull from the table, with their values set as conditions. Set the
     * value to null to not filter by the field but only add it to the resultSet
     *
     * @param table
     * @param fields
     * @return
     */
    public static ResultSet read(String table, Map<String, String> fields) {
        String query;
        query = "SELECT * FROM " + t(table);
        query += buildConditions(fields);
        return execute(query);
    }

    /**
     * Insert into the table a new record. If ID field is passed, an UPDATE will
     * be performed instead based on this condition.
     *
     * @param table
     * @param fields
     * @return recordsAffected int
     */
    public static int write(String table, Map<String, String> fields) {
        String query = "";
        String fieldList = "";
        String valueList = "";
        Boolean first = true;
        if (fields.get(id(table)) == null) {
            // Since the ID field was not passed, perform an INSERT
            for (Map.Entry<String, String> field : fields.entrySet()) {
                if (!first) {
                    fieldList += ", ";
                    valueList += ", ";
                }
                fieldList += t(field.getKey());
                valueList += e(field.getValue());
                first = false;
            }
            query = "INSERT INTO " + t(table) + " (" + fieldList + ") VALUES ("
                    + valueList + ")";
        } else {
            // Since the ID field WAS passed, perform an update
            query = "UPDATE " + t(table) + " SET (";
            for (Map.Entry<String, String> field : fields.entrySet()) {
                if (field.getKey().equals(id(table))) {
                    if (!first) {
                        query += ", ";
                    }
                    query += t(field.getKey()) + "=" + e(field.getValue());
                    first = false;
                }
            }
            query += ") WHERE " + t(table + "." + id(table)) + "="
                    + fields.get(id(table));
        }

        return executeWrite(query);
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
        query = "DELETE FROM " + t(table) + " WHERE " + t(id(table)) + "=" + id;
        return executeWrite(query);
    }

    /**
     * Delete a record from a table based on a map of field => value conditions
     * @param table
     * @param conditions
     * @return recordsAffected int
     */
    public static int delete(String table, Map<String, String> conditions) {
        String query = "";
        query = "DELETE FROM " + t(table);
        query += buildConditions(conditions);
        return executeWrite(query);
    }

    /**
     * Adds ` backticks around the table/field name. You can also pass
     * table.fieldname and they will individually be wrapped in backticks also.
     *
     * @param value String table/field name or table.fieldname combo
     * @return the value of table
     */
    public static String t(String value) {
        int index = value.indexOf(".");
        if (index >= 0) {
            value = "`" + value.substring(0, index) + "`.`" + value.substring(index) + "`";
        } else {
            value = "`" + value + "`";
        }
        return value;
    }

    /**
     * Escapes and wraps the value in single quotes
     *
     * @return the value of table
     */
    public static String e(String value) {
        value = "'" + value.replaceAll("'", "\'") + "'";
        return value;
    }

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
     * Executes a raw sql query
     *
     * @param query new value of query
     * @return resultset
     */
    public static ResultSet execute(String query) {
        System.out.println("Query: " +query);

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
        System.out.println("Query: " +query);
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
        connect = null;
        try {
            //connect = DriverManager.getConnection("jdbc:" + dbType + "://" + dbHost + "/" + dbDatabase + "?user=" + dbUsername + "&password=" + dbPassword);
            connect = DriverManager.getConnection("jdbc:" + dbType + "://" + dbHost + "/" + dbDatabase);
        } catch (Exception e) {
            System.out.println("Failed to connect");
            System.out.println(e.getMessage());
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
        }
    }
}
