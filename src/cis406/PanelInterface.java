/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Dean Sofer
 */
public interface PanelInterface {

    void clickNew();
    void clickSave();
    void clickLoad();
    void clickDelete();
    void clickReset();
    void clickCancel();
    void clickEditing();
    void clickBrowsing();
    void switchTo(String actionCommand);
    Boolean switchAway();

}
