/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> fields = new HashMap();

        fields.put("contact_id", Integer.toString(contact_id));
        fields.put("type", Integer.toString(type));
        fields.put("date", date);
        fields.put("note", notes);
        Database.write("correspondence", fields);
    }
}