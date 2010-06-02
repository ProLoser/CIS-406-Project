/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.Database;
import java.sql.ResultSet;

/**
 *
 * @author Mark Lenser
 */
public class Company {
    private int id;
    private String name;
    private int industry_id;

    public Company() {
    }
    public Company(int id) {
        ResultSet data = Database.read("company", id);
        try {
            data.next();
            this.id = id;
            name = data.getString("name");
            industry_id = data.getInt("industry_id");
           //Erorrs in company
        } catch (Exception e) {
            System.out.println("Failed to locate a record");
        }
    }
    public Company(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndustry_id() {
        return industry_id;
    }
    public void setIndustry_id(int industryId) {
        this.industry_id = industryId;
    }


    /**
     * Saves the company and returns the created id
     * @return newId if set to 0, save failed.
     */
    public int save() {
        int newId = 0;
        Database db = new Database("company");
        System.out.println("industry_id_comp:" + industry_id);
        db.addField("name", name);
        db.addField("industry_id", industry_id);
        try {
            newId = db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the company");
            System.out.println(e.getMessage());
        }
        return newId;
    }
}
