/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dean
 */
public class CisComboBox extends DefaultComboBoxModel {

    private ResultSet data;
    private String table;
    private String id;
    private String displayField;
    private String field1;
    private String field2;
    private String separator = ", ";

    public CisComboBox(String table, String displayField) {
        this.table = table;
        this.displayField = displayField;
        query("");
        addFields();
    }

    public CisComboBox(String table, String displayField, String conditions) {
        this.table = table;
        this.displayField = displayField;
        query(conditions);
        addFields();
    }

    public CisComboBox(String displayField, ResultSet data) {
        this.data = data;
        this.displayField = displayField;
        try {
            table = data.getMetaData().getTableName(1);
        } catch (Exception e) {
            System.out.println("Failed to set the table name");
            System.out.println(e.getMessage());
        }
        addFields();
    }

    public ResultSet getData() {
        return data;
    }

    public void setData(ResultSet data) {
        this.data = data;
    }

    public String getDisplayField() {
        return displayField;
    }

    public void setDisplayField(String displayField) {
        this.displayField = displayField;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    private void addFields() {
        try {
            while (data.next()) {
                addElement(new ComboItem(data.getString(displayField), data.getInt(Database.id(table))));
            }
        } catch (Exception e) {
            System.out.println("Failed to add the fields from the data");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a dataset to be used to populate a combobox
     *
     * @param query new value of query
     * @return resultset
     */
    private void query(String conditions) {
        String query;

        query = "SELECT " + Database.id(table) + ", " + displayField + " FROM " + table
                + " " + conditions;

        try {
            data = Database.execute(query);
        } catch (Exception e) {
            System.out.println("Failed to query the database");
            System.out.println(e.getMessage());
        }
    }
}

/**
 * Custom combo item object used for populating droplists
 * @author Dean
 */
class ComboItem {

    public String field;
    public int id;

    public ComboItem() {
    }

    public ComboItem(String field, int id) {
        this.field = field;
        this.id = id;
    }

    @Override
    public String toString() {
        return field;
    }
}
