/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Dean Sofer
 */
public class CareerPath {

    private String name;
    private String description;

    public CareerPath(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int save() {
        int newId = 0;
        Database db = new Database("career_path");
        db.addField("name", name);
        try {
            newId = db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the career path");
            System.out.println(e.getMessage());
        }
        return newId;
    }
}
