/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dean
 */
public class CisTable extends DefaultTableModel {

    private ResultSet data;
    private Vector<String> displayFields;
    private String idField;

    /**
     * Loads the results of an SQL ResultSet into the Table Model
     * @param data
     */
    CisTable(ResultSet data) {
        setData(data);
        displayFields = new Vector<String>();
    }

    /**
     * Loads an SQL table into the Table Model
     * @param table
     */
    CisTable(String table) {
        data = Database.read(table);
        displayFields = new Vector<String>();
    }

    public ResultSet getData() {
        return data;
    }

    public void setData(ResultSet data) {
        this.data = data;
    }

    /**
     * Specifies which fields from the data should be displayed
     * @param field
     */
    public void addDisplayField(String field) {
        displayFields.add(field);
    }

    public void removeDisplayField(String field) {
        displayFields.remove(field);
    }

    public Vector<String> getDisplayFields() {
        return displayFields;
    }

    public String getIdField() {
        return idField;
    }

    /**
     * Optional. Sets which field from the data is the primary key for the ID column
     * @param idField
     */
    public void setIdField(String idField) {
        this.idField = idField;
    }

    /**
     * Adds the columns and rows of the ResultSet data to the object
     */
    public CisTable parseData() {
        addColumns();
        addRows();
        return this;
    }

    /**
     * Iterates through the data adding the columns to the current object
     */
    public void addColumns() {
        if (displayFields.isEmpty()) {
            try {
                for (int i = 1; i <= data.getMetaData().getColumnCount(); i++) {
                    addColumn(f(data.getMetaData().getColumnName(i)));
                }
            } catch (Exception e) {
                System.out.println("Failed to add columns to the table");
                System.out.println(e.getMessage());
            }
        } else {
            for (String field : displayFields) {
                addColumn(f(field));
            }
        }
    }

    /**
     * Iterates through the data adding the rows to the current object
     */
    public void addRows() {
        Vector<Object> row;

        try {
            while (data.next()) {
                row = new Vector<Object>();
                if (displayFields.isEmpty()) {
                    for (int i = 1; i <= data.getMetaData().getColumnCount(); i++) {
                        row.add(data.getObject(i));
                    }
                } else {
                    for (String field : displayFields) {
                        row.add(data.getObject(field));
                    }
                }
                addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Failed to add the rows to the table");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Formats an SQL column fieldname to be human-readable
     * @param fieldname
     * @return fieldname
     */
    public String f(String fieldname) {
        if (!fieldname.equalsIgnoreCase(idField)) {
            String[] words = fieldname.split("_");
            fieldname = "";
            for (int i = 0; i < words.length; i++) {
                if (i != 0) {
                    fieldname += " ";
                }
                if (!words[i].equals("ID")) {
                    fieldname += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                }
            }
        } else {
            fieldname = "ID";
        }

        return fieldname;
    }
}