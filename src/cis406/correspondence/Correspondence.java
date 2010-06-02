/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.correspondence;

import cis406.TableModel;
import cis406.Database;
import cis406.Validation;
import java.util.Vector;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public Correspondence(int id) {
        ResultSet data = Database.read("correspondence", id);
        try {
            data.next();
            this.id = id;
            contact_id = data.getInt("contact_id");
            type = data.getInt("type");
            date = data.getString("date");
            notes = data.getString("note");
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
        }
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
    public int getContact_id() {
        return contact_id;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }
    public boolean setDate(String date) {
        if(Validation.isNotEmpty(date)) {
            this.date = date;
            return true;
        }
        else {
            return false;
        }
    }
    public String getDate() {
        if (date == null) {
            return null;
        }
        return date.toString();
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }
    public boolean save() {
        Database db = new Database("correspondence");

        db.addField("contact_id", Integer.toString(contact_id));
        db.addField("type", Integer.toString(type));
        db.addField("date", date);
        db.addField("note", notes);
        try {
            if (id == 0) {
                id = db.insert();
            } else {
                db.update(id);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to Add the correspondence");
            System.out.println(e.getMessage());
            return false;
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
        fields.add("contact.last_name AS contact");

        // Use table.fieldname when querying multiple tables joined together
        
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
    public static Boolean delete(int id) {
        Boolean success = false;
        if (Database.delete("correspondence", id) > 0) {
            success = true;
        } else {
            System.out.println("The correspondence could not be found");
        }

        return success;
    }
}