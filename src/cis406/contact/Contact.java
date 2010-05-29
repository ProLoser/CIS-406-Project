/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.Database;

/**
 *
 * @author Mark  Lenser
 */
public class Contact {
    private String fname;
    private String lname;
    private int company_id;
    private String street;
    private int zip;
    private String city;
    private String state;
    private String email;
    private int phone_area;
    private int phone_first;
    private int phone_last;
    private int phone_ext;
    private String phone;
    private String position;
    private int comm_method;
    private String description;
    //company
    private int companyId;
    private int industryId;

    public Contact() {
    }
    public Contact(String fname, String lname, int company_id, String street, int zip, String city, String state, String email, int phone_area, int phone_first, int phone_last, int phone_ext, String position, int comm_method, String description) {
        setFname(fname);
        setLname(lname);
        setCompany_id(company_id);
        setStreet(street);
        setZip(zip);
        setCity(city);
        setState(state);
        setEmail(email);
        setPhone(phone_area, phone_first, phone_last, phone_ext);
        setPosition(position);
        setComm_method(comm_method);
        setDescription(description);
    }

    //company
    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public int getIndustryId() {
        return industryId;
    }
    public void setIndustryId(int industryId) {
        this.industryId = industryId;
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
    public void setState(String state) {
        this.state = state;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(int phone_area, int phone_first, int phone_last, int phone_ext) {
        String phoneTemp = Integer.toString(phone_area) + Integer.toString(phone_first) + Integer.toString(phone_last) + Integer.toString(phone_ext);
        this.phone = phoneTemp;
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
        Database db = new Database("contact");
        db.addField("first_name", fname);
        db.addField("last_name", lname);
        db.addField("company_id", company_id);
        db.addField("street", street);
        db.addField("zip", Integer.toString(zip));
        db.addField("city", city);
        db.addField("state", state);
        db.addField("email", email);
        db.addField("phone", phone);
        db.addField("position", position);
        db.addField("preferred_contact", Integer.toString(comm_method));
        db.addField("initial_contact_description", description);
        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to Add the contact_person");
            System.out.println(e.getMessage());
        }
    }
}