/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPanel.java
 *
 * Created on May 24, 2010, 6:20:48 PM
 */

package cis406;

import cis406.*;
import java.awt.CardLayout;

/**
 *
 * @author Owner
 */
public class MainPanel extends javax.swing.JPanel implements CisPanel {
String activeCard = "Browse";
    /** Creates new form MainPanel */
    public MainPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new cis406.StudentEditPanel();
        browsePanel = new cis406.StudentBrowsePanel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.CardLayout());

        editPanel.setName("editPanel"); // NOI18N
        add(editPanel, "Edit");

        browsePanel.setName("browsePanel"); // NOI18N
        add(browsePanel, "Browse");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cis406.StudentBrowsePanel browsePanel;
    private cis406.StudentEditPanel editPanel;
    // End of variables declaration//GEN-END:variables

    public void clickBrowsing() {
        CardLayout cl = (CardLayout) (getLayout());
        cl.show(this, "Browse");
        activeCard = "Browse";
    }

    public void clickCancel() {
    }

    public void clickClear() {
        editPanel.reset();
    }

    public void clickDelete() {
    }

    public void clickEditing() {
        CardLayout cl = (CardLayout) (getLayout());
        cl.show(this, "Edit");
        activeCard = "Edit";
    }

    public void clickLoad() {
        clickEditing();
    }

    public void clickNew() {
        CardLayout cl = (CardLayout) (getLayout());
        cl.show(this, "Edit");
        activeCard = "Edit";
    }

    public void clickSave() {
            editPanel.save();
    }

    public void switchAway() {
    }

    public void switchTo(String actionCommand) {
        if (actionCommand.equalsIgnoreCase("Edit")) {
            clickEditing();
        } else {
            clickBrowsing();
        }
    }
}
