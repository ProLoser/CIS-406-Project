/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.internship;

import cis406.TableModel;
import cis406.Database;
import java.io.File;
import java.sql.Blob;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Dean Sofer
 */
public class Internship {

    private int id = 0; // By default if a new record
    private int companyId;
    private int careerPathId;
    private String title;
    private String description;
    private Date postDate;
    private Date expiration;
    private int quantity;
    private String attachment;
    private Blob attachmentData;

    public Internship() {
    }

    /**
     * Loads an internship from the db and Populates the object with the record information
     * @param id
     */
    public Internship(int id) {
        ResultSet data = Database.read("internship", id);
        try {
            data.next();
            title =data.getString("title");
            careerPathId = data.getInt("career_path_id");
            companyId = data.getInt("company_id");
            description = data.getString("description");
            quantity = data.getInt("quantity");
            postDate = data.getDate("post_date");
            expiration = data.getDate("expiration");
            attachmentData = data.getBlob("attachment");
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
        }
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getCareerPathId() {
        return careerPathId;
    }

    public void setCareerPathId(int careerPathId) {
        this.careerPathId = careerPathId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiration() {
        if (expiration == null)
            return null;
        return expiration.toString();
    }

    public boolean setExpiration(String expiration) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.expiration = df.parse(expiration);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the expiration date");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostDate() {
        if (postDate == null)
            return null;
        return postDate.toString();
    }

    public boolean setPostDate(String postDate) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.postDate = df.parse(postDate);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the post date");
            return false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean setQuantity(String quantity) {
        try {
            this.quantity = Integer.parseInt(quantity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Handles both updating existing records and adding new ones, depending on
     * if the id attribute = 0
     * @return
     */
    public Boolean save() {
        java.sql.Date sqlDate;
        Database db = new Database("internship");
        db.addField("title", title);
        // Add Attachment
        File attachmentFile = new File(attachment);
        //db.addField("attachment", attachmentFile);

        db.addField("company_id", companyId);
        db.addField("career_path_id", careerPathId);
        // Add date fields

        sqlDate = new java.sql.Date(postDate.getTime());
        db.addField("post_date", sqlDate);
        if (expiration != null) {
            sqlDate = new java.sql.Date(expiration.getTime());
            db.addField("expiration", sqlDate);
        }
        db.addField("description", description);
        db.addField("quantity", quantity);
        try {
            if (id == 0) {
                db.insert();
            } else {
                db.update(id);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to add the internship");
            System.out.println(e.getMessage());
            return false;
        }
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

    /**
     * Populates a internships report table
     * @return
     */
    public static TableModel generateTable() {
        Database db = new Database("internship");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("company");
        db.innerJoin("career_path");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as.
        fields.add("title");
        fields.add("post_date AS posted");
        fields.add("expiration AS expires");
        fields.add("quantity AS positions");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("career_path.name AS career_path");
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
}
