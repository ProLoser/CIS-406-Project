/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.Database;

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
}