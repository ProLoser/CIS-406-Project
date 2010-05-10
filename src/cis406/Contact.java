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
public class Contact {
    private String fname;
    private String lname;
    private int company_id;
    private String street;
    private int zip;
    private String city;
    private int state;
    private String email;
    private int phone_area;
    private int phone_first;
    private int phone_last;
    private int phone;
    private String position;
    private int comm_method;
    private String description;

    public Contact() {
    }
    public Contact(String fname, String lname, int company_id, String street, int zip, String city, int state, String email, int phone_area, int phone_first, int phone_last, String position, int comm_method, String description) {
        setFname(fname);
        setLname(lname);
        setCompany_id(company_id);
        setStreet(street);
        setZip(zip);
        setCity(city);
        setState(state);
        setEmail(email);
        setPhone(phone_area, phone_first, phone_last);
        setPosition(position);
        setComm_method(comm_method);
        setDescription(description);
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(int phone_area, int phone_first, int phone_last) {
        this.phone = phone_area + phone_first + phone_last;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setComm_method(int comm_method) {
        this.comm_method = comm_method;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void save() {
        Map<String, String> fields = new HashMap();

        fields.put("first_name", fname);
        fields.put("last_name", lname);
        fields.put("company_id", Integer.toString(company_id));
        fields.put("street", street);
        fields.put("zip", Integer.toString(zip));
        fields.put("city", city);
        fields.put("state", Integer.toString(state));
        fields.put("email", email);
        fields.put("phone", Integer.toString(phone));
        fields.put("position", position);
        fields.put("preferred_contact", Integer.toString(comm_method));
        fields.put("initial_contact_description", description);
        Database.write("contact_person", fields);
    }
}