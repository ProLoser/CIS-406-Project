/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.internship;

import cis406.TableModel;
import cis406.Database;
import cis406.Validation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private String postDate;
    private String expiration;
    private int quantity;
    private String attachment = "";
    private String folder;
    private String originalAttachment = "";
    private InputStream attachmentData;

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
            title = data.getString("title");
            careerPathId = data.getInt("career_path_id");
            companyId = data.getInt("company_id");
            description = data.getString("description");
            quantity = data.getInt("quantity");
            postDate = data.getString("post_date");
            expiration = data.getString("expiration");
            attachmentData = data.getBinaryStream("attachment");
            attachment = data.getString("filename");
            originalAttachment = attachment;
            this.id = id;
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
            System.out.println(e.getMessage());
        }
    }

    public String getAttachment() {
        return attachment;
    }

    public boolean downloadAttachment(String newFolder) {
        boolean success = false;
        try {
            File f = new File(newFolder + "//" + attachment);
            OutputStream out = new FileOutputStream(f);
            byte buf[] = new byte[1024];
            int len;
            while ((len = attachmentData.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            success = true;
        } catch (Exception e) {
            System.out.println("Unable to download:" + newFolder + "//" + attachment);
            e.printStackTrace();
        }
        return success;
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
        if (expiration == null) {
            return null;
        }
        return expiration;
    }

    public boolean setExpiration(String expiration) {
        if (Validation.isDate(expiration)) {
            this.expiration = expiration;
            return true;
        } else {
            this.expiration = null;
            return false;
        }
    }

    public void resetExpiration() {
        expiration = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostDate() {
        if (postDate == null) {
            return null;
        }
        return postDate;
    }

    public boolean setPostDate(String postDate) {
        DateFormat df = new SimpleDateFormat("y-M-d");
        try {
            df.parse(postDate);
            this.postDate = postDate;
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

    public Boolean setTitle(String title) {
        if (title.isEmpty()) {
            return false;
        } else {
            this.title = title;
            return true;
        }
    }

    /**
     * Handles both updating existing records and adding new ones, depending on
     * if the id attribute = 0
     * @return
     */
    public boolean save() {
        Database db = new Database("internship");
        db.addField("title", title);
        // Add Attachment
        if (!attachment.isEmpty() && !attachment.equals(originalAttachment)) {
            File attachmentFile = new File(attachment);
            db.addField("attachment", attachmentFile);
            db.addField("filename", attachmentFile.getName());
        } else if (attachment.isEmpty() && originalAttachment != null && !originalAttachment.isEmpty()) {
            db.addField("attachment", null);
            db.addField("filename", null);
        }

        db.addField("company_id", companyId);
        db.addField("career_path_id", careerPathId);
        // Add date fields

        db.addField("post_date", postDate);
        if (expiration != null) {
            db.addField("expiration", expiration);
        }
        db.addField("description", description);
        db.addField("quantity", quantity);
        try {
            if (id == 0) {
                id = db.insert();
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
        db.setOrderBy("post_date DESC");
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

    @Override
    public boolean equals(Object obj) {
        boolean match = false;
        Internship compare = (Internship) obj;
        if (companyId == compare.companyId
                || careerPathId == compare.careerPathId
                || title.equals(compare.title)
                || description.equals(compare.description)
                || postDate == compare.postDate
                || expiration == compare.expiration
                || attachment.equals(compare.attachment)) {
            match = true;
        }
        return match;
    }
}
