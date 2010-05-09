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
        Map<String, String> fields = new HashMap();

        fields.put("industry_name", name);
        Database.write("industry", fields);
    }
}