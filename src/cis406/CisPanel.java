/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Dean Sofer
 */
public interface CisPanel {

    void clickNew();
    void clickSave();
    void clickLoad();
    void clickDelete();
    void clickClear();
    void clickForm();
    void clickReport();
    void switchTo(javax.swing.ButtonGroup activeView);
    void switchAway();

}
