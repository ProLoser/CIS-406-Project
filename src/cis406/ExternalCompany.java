/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Mark
 */
public class ExternalCompany {
    private int industry;
    private String name;
    private String ext;

    public ExternalCompany() {
    }
    public ExternalCompany(int industry, String name, String ext) {
        setIndustry(industry);
        setName(name);
        setExt(ext);
    }
    public void setIndustry(int industry) {
        this.industry = industry;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }
    public void save() {
        Database db = new Database("company");

        db.addField("industry_id", industry);
        db.addField("name", name);
        db.addField("phone", ext);

        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to Add the company");
            System.out.println(e.getMessage());
        }
    }
}