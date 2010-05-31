/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.correspondence;

import cis406.TableModel;
import cis406.Database;
import java.util.Vector;
import java.sql.ResultSet;

/**
 *
 * @author Mark
 */
public class Correspondence {
    private int id;
    private int contact_id;
    private int type;
    private String date;
    private String notes;

    public Correspondence() {
    }
    public Correspondence(int contact_id, int type, String date, String notes) {
        setContact_id(contact_id);
        setType(type);
        setDate(date);
        setNotes(notes);
    }
    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void save() {
        Database db = new Database("correspondence");

        db.addField("contact_id", Integer.toString(contact_id));
        db.addField("type", Integer.toString(type));
        db.addField("date", date);
        db.addField("note", notes);
        
        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to Add the correspondence");
            System.out.println(e.getMessage());
        }
    }
    /**
     * Populates a internships report table
     * @return
     */
    public static TableModel generateTable() {
        Database db = new Database("correspondence");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("contact");

        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as.
        fields.add("date");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("contact.last_name AS contact");
        
        try {
            // Generate the table from the query
            table = new TableModel(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the internship table");
            System.out.println(e.getMessage());
        }
        return table;
    }
}