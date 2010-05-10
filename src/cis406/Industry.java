/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Mark
 */
public class Industry {
    private String name;

    public Industry() {
    }
    public Industry(String name) {
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void save() {
        Database db = new Database("industry");
        db.addField("industry_name", name);
        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the industry");
            System.out.println(e.getMessage());
        }
    }
}