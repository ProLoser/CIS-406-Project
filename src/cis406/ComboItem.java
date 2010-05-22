/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Dean
 */
public class ComboItem {

    public String field;
    public int id;

    public ComboItem() {
    }

    public ComboItem(String field, int id) {
        this.field = field;
        this.id = id;
    }

    @Override
    public String toString() {
        return field;
    }

}
