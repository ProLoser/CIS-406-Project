/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Dean Sofer
 */
public class Internship {

    private int id;
    private int company_id;
    private int career_path_id;
    private String title;
    private String description;
    private String post_date;
    private String expiration;
    private int quantity;
    private String attachment;

    public Internship() {
    }

    public Internship(int company_id, int career_path_id, String title, String description, String post_date, String expiration, int quantity, String attachment) {
        this.company_id = company_id;
        this.career_path_id = career_path_id;
        this.title = title;
        this.description = description;
        this.post_date = post_date;
        this.expiration = expiration;
        this.quantity = quantity;
        this.attachment = attachment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getCareer_path_id() {
        return career_path_id;
    }

    public void setCareer_path_id(int career_path_id) {
        this.career_path_id = career_path_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
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
        
        String fields = "company_id, title, description, post_date, expiration, quantity, career_path_id, attachment";
        String values = company_id + ", " + title + ", " + description
                + ", " + post_date + ", " + expiration + ", " + quantity
                + ", " + career_path_id + ", " + attachment;
        

        Database.executeWrite("INSERT INTO internship (" + fields + ") VALUES (" + values + ")");
    }

}