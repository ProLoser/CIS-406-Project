/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.internship;

import cis406.CisTable;
import cis406.Database;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dean Sofer
 */
public class Internship {

    private int id;
    private int companyId;
    private int careerPathId;
    private String title;
    private String description;
    private Date postDate;
    private Date expiration;
    private int quantity;
    private String attachment;

    public Internship() {
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void save() {
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
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the internship");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Populates a internships report table
     * @return
     */
    static public CisTable generateTable() {
        Database db = new Database("internship");
        CisTable table = null;
        Map<String, String> fields = new HashMap<String, String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("company");
        db.innerJoin("career_path");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as. Use null to not alias.
        fields.put("title", null);
        fields.put("post_date", "posted");
        fields.put("expiration", "expires");
        fields.put("quantity", "positions");
        // Use table.fieldname when querying multiple tables joined together
        fields.put("career_path.name", "career_path");
        fields.put("company.name", "company");
        try {
            // Generate the table from the query
            table = new CisTable(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the internship table");
            System.out.println(e.getMessage());
        }
        return table;
    }
}