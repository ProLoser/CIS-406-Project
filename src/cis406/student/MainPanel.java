/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPanel.java
 *
 * Created on May 24, 2010, 6:20:48 PM
 */
package cis406.student;

import cis406.*;
import cis406.PanelInterface;
import java.awt.CardLayout;

/**
 *
 * @author Owner
 */
public class MainPanel extends javax.swing.JPanel implements PanelInterface {

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

        editPanel = new cis406.student.EditPanel();
        browsePanel = new cis406.student.BrowsePanel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.CardLayout());

        editPanel.setName("editPanel"); // NOI18N
        add(editPanel, "Edit");

        browsePanel.setName("browsePanel"); // NOI18N
        add(browsePanel, "Browse");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cis406.student.BrowsePanel browsePanel;
    private cis406.student.EditPanel editPanel;
    // End of variables declaration//GEN-END:variables

    public void browsing() {
        CardLayout cl = (CardLayout) (getLayout());
        cl.show(this, "Browse");
        activeCard = "Browse";
        browsePanel.loadTable();
    }

    public void editing() {
        CardLayout cl = (CardLayout) (getLayout());
        cl.show(this, "Edit");
        activeCard = "Edit";
    }

    public void clickCancel() {
        browsing();
    }

    public void clickReset() {
    if (activeCard.equals("Edit")) {
            editPanel.reset();
        } else {
            browsePanel.loadTable();
        }
    }

    public void clickDelete() {
          if (activeCard.equals("Browse")) {
            browsePanel.delete();
        } else {
        }
    }

    public void clickLoad() {
if (activeCard.equals("Browse")) {
            int record = browsePanel.getSelectedRow();
            if (record != 0) {
                editing();
                editPanel.load(record);
            }
        }
    }

    public void clickNew() {
        editPanel.newStudent();
        editing();
    }

    public void clickSave() {
        if (activeCard.equals("Edit") && editPanel.save()) {
            browsing();
        }
    }

    public Boolean switchAway() {
        return true;
    }

    public void switchTo(String actionCommand) {
            browsing();
    }
}
