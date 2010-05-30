/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dean
 */
public class ComboBoxModel extends DefaultComboBoxModel {

    private ResultSet data;
    private String table;
    private String id;
    private String displayField;
    private String field1;
    private String field2;
    private String separator = ", ";
    private Map rows;

    public ComboBoxModel(String table, String displayField) {
        this.table = table;
        this.displayField = displayField;
        query(" ORDER BY " + displayField + " ASC");
        addFields();
    }

    public ComboBoxModel(String table, String displayField, String conditions) {
        this.table = table;
        this.displayField = displayField;
        query(conditions);
        addFields();
    }

    public ComboBoxModel(String displayField, ResultSet data) {
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

    /**
     * Sets the currently selected item to be the item that matches the id#
     * @param id
     */
    public void setSelectedId(int id) {
        setSelectedItem(rows.get(id));
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
        ComboItem row;
        rows = new HashMap();
        try {
            while (data.next()) {
                row = new ComboItem(data.getString(displayField), data.getInt(Database.id(table)));
                addElement(row);
                rows.put(data.getInt(Database.id(table)), row);
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