/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.TableModel;
import cis406.Database;
import cis406.Validation;
import java.util.Vector;
import java.sql.ResultSet;


/**
 *
 * @author Mark  Lenser
 */
public class Contact {
    private String fname;
    private String lname;
    private String street;
    private int zip;
    private String city;
    private String state;
    private String email;
    private int phone;
    private String position;
    private int comm_method;
    private String description;

    private int company_id;
    private int industry_id;

    public Contact() {
    }
    public Contact(int id) {
        ResultSet data = Database.read("contact", id);
        try {
            data.next();
            fname = data.getString("first_name");
            lname = data.getString("last_name");
            company_id = data.getInt("company_id");
            ResultSet compData = Database.read("company", company_id);
            try {
                compData.next();
                industry_id = compData.getInt("industry_id");
            } catch (Exception e) {
                System.out.println("Failed to locate a company");
            }
            street = data.getString("street");
            zip = data.getInt("zip");
            city = data.getString("city");
            state = data.getString("state");
            email = data.getString("email");
            phone = data.getInt("phone");
            position = data.getString("position");
            comm_method = data.getInt("preferred_contact");
            description = data.getString("initial_contact_description");

           //Erorrs in industry
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
        }
    }
    public Contact(String fname, String lname, int company_id, String street, String zip, String city, String state, String email, String phone, String position, int comm_method, String description) {
        setFname(fname);
        setLname(lname);
        setCompany_id(company_id);
        setStreet(street);
        setZip(zip);
        setCity(city);
        setState(state);
        setEmail(email);
        setPhone(phone);
        setPosition(position);
        setComm_method(comm_method);
        setDescription(description);
    }

    //company

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
    public int getCompany_id() {
        return company_id;
    }
    public int getIndustry_id() {
        return industry_id;
    }
    public void setIndustry_id(int industryId) {
        this.industry_id = industryId;
    }
    //Contact
    public boolean setFname(String fname) {
        if(Validation.isNotEmpty(fname) && Validation.isChars(fname)) {
            this.fname = fname;
            return true;
        }
        else {
            return false;
        }
    }
    public String getFname() {
        return fname;
    }
    public boolean setLname(String lname) {
        if(Validation.isNotEmpty(lname) && Validation.isChars(lname)) {
            this.lname = lname;
            return true;
        }
        else {
            return false;
        }
    }
    public String getLname() {
        return lname;
    }
    public boolean setStreet(String street) {
        if(Validation.isNotEmpty(street)) {
            if(Validation.isCharsNumsSpaces(street))
            {
                this.street = street;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }
    public String getStreet() {
        return street;
    }
    public boolean setZip(String zip) {
        if(Validation.isNotEmpty(zip)) {
            if(Validation.isNums(zip))
            {
                this.zip = Integer.parseInt(zip);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }
    public int getZip() {
        return zip;
    }

    public boolean setCity(String city) {
        if(Validation.isNotEmpty(city)) {
            if(Validation.isChars(city))
            {
                this.city = city;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
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
    public boolean setEmail(String email) {
        if(Validation.isNotEmpty(email) && Validation.isValidEmailAddress(email)) {
            this.email = email;
            return true;
        }
        else {
            return false;
        }
    }
    public String getEmail() {
        return email;
    }
    public boolean setPhone(String phone) {
        if(Validation.isNotEmpty(phone)) {
            if(Validation.isNums(phone)) {
                try {
                    this.phone = Integer.parseInt(phone);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }
    public int getPhone() {
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
        if (Database.delete("contact", id) > 0) {
            success = true;
        } else {
            System.out.println("The contact could not be found");
        }

        return success;
    }
}