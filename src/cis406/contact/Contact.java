/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.TableModel;
import cis406.Database;
import java.util.Vector;
import java.sql.ResultSet;


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
    private int industryId;

    public Contact() {
    }
    public Contact(int id) {
        ResultSet data = Database.read("contact", id);
        try {
            data.next();
            fname = data.getString("first_name");
            lname = data.getString("last_name");
            company_id = data.getInt("company_id");
            street = data.getString("street");
            zip = data.getInt("zip");
            city = data.getString("city");
            state = data.getString("state");
            email = data.getString("email");
            phone = data.getString("phone");
            position = data.getString("position");
            comm_method = data.getInt("comm_method");
            description = data.getString("description");
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
        }
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
    public int getIndustryId() {
        return industryId;
    }
    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }
    //Contact
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getFname() {
        return fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getLname() {
        return lname;
    }
    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
    public int getCompany_id() {
        return company_id;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {
        return street;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public int getZip() {
        return zip;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPhone(int phone_area, int phone_first, int phone_last, int phone_ext) {
        String phoneTemp = Integer.toString(phone_area) + Integer.toString(phone_first) + Integer.toString(phone_last) + Integer.toString(phone_ext);
        this.phone = phoneTemp;
    }
    public String getPhone() {
        return phone;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    public void setComm_method(int comm_method) {
        this.comm_method = comm_method;
    }
    public int getComm_method() {
        return comm_method;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
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
     /**
     * Populates a internships report table
     * @return
     */
    public static TableModel generateTable() {
        Database db = new Database("contact");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("company");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as.
        fields.add("first_name");
        fields.add("last_name");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("company.name AS company");
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
    /**
     * Deletes an internship record from the database at the specified id
     * @param id
     * @return
     */
    public static Boolean delete(int id) {
        Boolean success = false;
        if (Database.delete("internship", id) > 0) {
            success = true;
        } else {
            System.out.println("The internship could not be found");
        }

        return success;
    }
}