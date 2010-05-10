/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Internship(int companyId, int careerPathId, String title, String description, String postDate, String expiration, int quantity, String attachment) {
        this.companyId = companyId;
        this.careerPathId = careerPathId;
        this.title = title;
        this.description = description;
        setPostDate(postDate);
        setExpiration(expiration);
        this.quantity = quantity;
        this.attachment = attachment;
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

    public void setExpiration(String expiration) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.postDate = df.parse(expiration);
        } catch (Exception e) {
            System.out.println("Failed to convert the expiration date");
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

    public void setPostDate(String postDate) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.postDate = df.parse(postDate);
        } catch (Exception e) {
            System.out.println("Failed to convert the post date");
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
        Database db = new Database("internship");
        db.addField("title", title);
        // Add Attachment
        File attachmentFile = new File(attachment);
        //db.addField("attachment", attachmentFile);
        
        db.addField("company_id", companyId);
        db.addField("career_path_id", careerPathId);
        // Add date fields
        /*java.sql.Date aDate = new java.sql.Date(postDate.getTime());
        db.addField("post_date", aDate);
        aDate = new java.sql.Date(expiration.getTime());
        db.addField("expiration", aDate);*/
        db.addField("description", description);
        db.addField("quantity", quantity);
        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the internship");
            System.out.println(e.getMessage());
        }
    }
}
