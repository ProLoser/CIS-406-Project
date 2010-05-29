/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.contact;

import cis406.Database;

/**
 *
 * @author Mark Lenser
 */
public class Industry {
    private String name;

    public Industry(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Saves the Industry and returns the created id
     * @return newId if set to 0, save failed.
     */
    public int save() {
        int newId = 0;
        Database db = new Database("industry");
        db.addField("industry_name", name);
        try {
            newId = db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the industry");
            System.out.println(e.getMessage());
        }
        return newId;
    }
}