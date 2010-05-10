/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> fields = new HashMap();

        fields.put("industry_id", Integer.toString(industry));
        fields.put("name", name);
        fields.put("phone", ext);
        Database.write("company", fields);
    }
}