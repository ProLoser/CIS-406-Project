/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentPanel.java
 *
 * Created on Apr 22, 2010, 6:05:03 AM
 */
package cis406.student;

import cis406.ComboBoxModel;
import cis406.DateUtils;
import java.awt.Color;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author Oscar Munoz
 */
public class EditPanel extends javax.swing.JPanel {

    /** Creates new form StudentPanel */
    public EditPanel() {
        initComponents();
        lblPostedDate.setText(DateUtils.now());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBroncoNum = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        cboMajor = new javax.swing.JComboBox();
        cboMinor = new javax.swing.JComboBox();
        txtLastCis = new javax.swing.JTextField();
        cboStanding = new javax.swing.JComboBox(standing);
        cboQuarter = new javax.swing.JComboBox(quarters);
        cboGradYr = new javax.swing.JComboBox(term_year);
        chkRelocate = new javax.swing.JCheckBox();
        chkSWIFT = new javax.swing.JCheckBox();
        chkMISSA = new javax.swing.JCheckBox();
        chkOtherClub = new javax.swing.JCheckBox();
        chkFAST = new javax.swing.JCheckBox();
        chkIWDSA = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaInterests = new javax.swing.JTextArea();
        lblBronco = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnInternship = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblPostedDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkGraduated = new javax.swing.JCheckBox();

        setName("Form"); // NOI18N

        txtBroncoNum.setFocusCycleRoot(true);
        txtBroncoNum.setName("txtBroncoNum"); // NOI18N
        txtBroncoNum.setNextFocusableComponent(txtFName);

        txtFName.setName("txtFName"); // NOI18N
        txtFName.setNextFocusableComponent(txtLName);

        txtLName.setName("txtLName"); // NOI18N
        txtLName.setNextFocusableComponent(txtPhone);

        txtPhone.setName("txtPhone"); // NOI18N
        txtPhone.setNextFocusableComponent(txtEmail);

        txtEmail.setName("txtEmail"); // NOI18N
        txtEmail.setNextFocusableComponent(txaInterests);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        cboMajor.setModel(new cis406.ComboBoxModel("major", "major_name"));
        cboMajor.setName("cboMajor"); // NOI18N
        cboMajor.setNextFocusableComponent(cboMinor);

        cboMinor.setModel(new cis406.ComboBoxModel("minor", "minor_name"));
        cboMinor.setName("cboMinor"); // NOI18N
        cboMinor.setNextFocusableComponent(txtLastCis);

        txtLastCis.setName("txtLastCis"); // NOI18N
        txtLastCis.setNextFocusableComponent(cboStanding);

        cboStanding.setModel(new javax.swing.DefaultComboBoxModel(standing));
        cboStanding.setName("cboStanding"); // NOI18N
        cboStanding.setNextFocusableComponent(cboQuarter);

        cboQuarter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fall", "Winter", "Spring", "Summer", " " }));
        cboQuarter.setName("cboQuarter"); // NOI18N
        cboQuarter.setNextFocusableComponent(cboGradYr);

        cboGradYr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));
        cboGradYr.setName("cboGradYr"); // NOI18N
        cboGradYr.setNextFocusableComponent(chkRelocate);

        chkRelocate.setName("chkRelocate"); // NOI18N

        chkSWIFT.setName("chkSWIFT"); // NOI18N

        chkMISSA.setName("chkMISSA"); // NOI18N

        chkOtherClub.setName("chkOtherClub"); // NOI18N
        chkOtherClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOtherClubActionPerformed(evt);
            }
        });

        chkFAST.setName("chkFAST"); // NOI18N

        chkIWDSA.setName("chkIWDSA"); // NOI18N
        chkIWDSA.setNextFocusableComponent(btnInternship);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txaInterests.setColumns(20);
        txaInterests.setLineWrap(true);
        txaInterests.setRows(5);
        txaInterests.setWrapStyleWord(true);
        txaInterests.setName("txaInterests"); // NOI18N
        txaInterests.setNextFocusableComponent(cboMajor);
        jScrollPane1.setViewportView(txaInterests);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(EditPanel.class);
        lblBronco.setText(resourceMap.getString("lblBronco.text")); // NOI18N
        lblBronco.setName("lblBronco"); // NOI18N

        lblFName.setText(resourceMap.getString("lblFName.text")); // NOI18N
        lblFName.setName("lblFName"); // NOI18N

        lblPhone.setText(resourceMap.getString("lblPhone.text")); // NOI18N
        lblPhone.setName("lblPhone"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        lblLName.setText(resourceMap.getString("lblLName.text")); // NOI18N
        lblLName.setName("lblLName"); // NOI18N

        lblEmail.setText(resourceMap.getString("lblEmail.text")); // NOI18N
        lblEmail.setName("lblEmail"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.setNextFocusableComponent(chkMISSA);

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N
        jLabel18.setNextFocusableComponent(chkIWDSA);

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setNextFocusableComponent(chkOtherClub);

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N
        jLabel20.setNextFocusableComponent(chkFAST);

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(EditPanel.class, this);
        btnInternship.setAction(actionMap.get("launchInternshipAssign")); // NOI18N
        btnInternship.setText(resourceMap.getString("btnInternship.text")); // NOI18N
        btnInternship.setName("btnInternship"); // NOI18N
        btnInternship.setNextFocusableComponent(txtBroncoNum);

        jLabel2.setName("jLabel2"); // NOI18N

        lblPostedDate.setFont(resourceMap.getFont("lblPostedDate.font")); // NOI18N
        lblPostedDate.setText(resourceMap.getString("lblPostedDate.text")); // NOI18N
        lblPostedDate.setName("lblPostedDate"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        chkGraduated.setText(resourceMap.getString("chkGraduated.text")); // NOI18N
        chkGraduated.setName("chkGraduated"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBronco)
                            .addComponent(lblLName)
                            .addComponent(lblFName))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLName)
                            .addComponent(txtFName)
                            .addComponent(txtBroncoNum, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone)
                            .addComponent(lblEmail)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(txtPhone))))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInternship)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPostedDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboMinor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMajor, 0, 222, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboStanding, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLastCis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGradYr, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkOtherClub)
                                    .addComponent(chkMISSA)
                                    .addComponent(chkSWIFT, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel20))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkFAST)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkIWDSA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkRelocate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkGraduated)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBronco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBroncoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGradYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMinor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastCis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboStanding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                            .addComponent(chkRelocate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSWIFT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkFAST, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkMISSA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkIWDSA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkOtherClub, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(chkGraduated)
                                .addComponent(jLabel5))
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPostedDate))
                .addGap(18, 18, 18)
                .addComponent(btnInternship)
                .addContainerGap(136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkOtherClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOtherClubActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_chkOtherClubActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtEmailActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInternship;
    private javax.swing.JComboBox cboGradYr;
    private javax.swing.JComboBox cboMajor;
    private javax.swing.JComboBox cboMinor;
    private javax.swing.JComboBox cboQuarter;
    private javax.swing.JComboBox cboStanding;
    private javax.swing.JCheckBox chkFAST;
    private javax.swing.JCheckBox chkGraduated;
    private javax.swing.JCheckBox chkIWDSA;
    private javax.swing.JCheckBox chkMISSA;
    private javax.swing.JCheckBox chkOtherClub;
    private javax.swing.JCheckBox chkRelocate;
    private javax.swing.JCheckBox chkSWIFT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBronco;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPostedDate;
    private javax.swing.JTextArea txaInterests;
    private javax.swing.JTextField txtBroncoNum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtLastCis;
    private javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
    private String fName;
    private String lName;
    private String broncoNum;
    private String email;
    private String phone;
    private String gradeLvl;
    private String lastCIS;
    private String interests;
    private String relocate;
    private String major;
    private String minor;
    private String gradDate;
    private String clubMissa;
    private String clubSwift;
    private String clubFast;
    private String clubIwdsa;
    private String clubOther;
    private Boolean chkMissa;
    private Boolean chkSwift;
    private Boolean chkFast;
    private Boolean chkIwdsa;
    private Boolean chkOther;
    private Boolean chkRelocateTst;
    Student newStudent = null;
    HashMap fields = new HashMap();
    private String lastUpdate;
    Date now = new Date();
    String nowTime = now.toString();
    String[] quarters = {"Fall", "Winter", "Spring", "Summer"};
    String[] term_year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};
    String[] standing = {"Freshman ( <44 units ) ", "Sophomore ( 45-89 units ) ", "Junior( 90-134 units ) ", "Senior ( 135+ units ) "};

    public void newStudent() {
        newStudent = new Student();
    }

    public Boolean save() {

        Boolean success = true;
        if (!newStudent.setBroncoNum(txtBroncoNum.getText())) {
            lblBronco.setForeground(Color.red);
            success = false;
        } else {
            lblBronco.setForeground(Color.black);
        }
        newStudent.lastName = (txtLName.getText());
        newStudent.firstName = txtFName.getText();
        newStudent.email = txtEmail.getText();
        newStudent.phone = txtPhone.getText();
        newStudent.gradeLevel = cboStanding.getSelectedIndex();
        newStudent.updateDate = now;
        newStudent.interests = txaInterests.getText();
        newStudent.major = ((cis406.ComboItem) cboMajor.getSelectedItem()).id;
        newStudent.minor = ((cis406.ComboItem) cboMinor.getSelectedItem()).id;
        newStudent.gradQtr = ((cis406.ComboItem) cboQuarter.getSelectedItem()).id;
        newStudent.gradYr = ((cis406.ComboItem) cboGradYr.getSelectedItem()).id;
        newStudent.lastCISCourse = txtLastCis.getText();
        newStudent.setRelocate(chkRelocate.isSelected());
        newStudent.setClubMissa(chkMISSA.isSelected());
        newStudent.setClubFast(chkFAST.isSelected());
        newStudent.setClubIwdsa(chkIWDSA.isSelected());
        newStudent.setClubSwift(chkSWIFT.isSelected());
        newStudent.setClubOther(chkOtherClub.isSelected());
        newStudent.setGraduated(chkGraduated.isSelected());

        if (!success) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Bronco Number");
            success = false;
            return success;
        } else {
            newStudent.save();
            return success;
        }
    }

    public void load(int id) {
        Student data = new Student(id);
        txtBroncoNum.setText(Integer.toString(data.broncoNum));
        txtLName.setText(data.getLastName());
        txtFName.setText(data.getFirstName());
        txtEmail.setText(data.getEmail());
        txtPhone.setText(data.getPhone());
        cboStanding.setSelectedItem(data.getGradeLevel());
        lblPostedDate.setText(data.getUpdateDate());
        txaInterests.setText(data.interests);
        ((ComboBoxModel)cboMajor.getModel()).setSelectedId(data.getMajor());
        ((ComboBoxModel)cboMinor.getModel()).setSelectedId(data.getMinor());
        cboQuarter.setSelectedItem(data.getGradQtr());
        cboGradYr.setSelectedItem(data.getGradYr());
        txtLastCis.setText(data.getLastCISCourse());

        if (data.getRelocate() ==1){
            chkRelocate.setSelected(true);
        }else{
            chkRelocate.setSelected(false);
        }

        if (data.getClubMissa() ==1){
            chkMISSA.setSelected(true);
        }else{
            chkMISSA.setSelected(false);
        }

        if (data.getClubFast() ==1){
            chkFAST.setSelected(true);
        }else{
            chkFAST.setSelected(false);
        }

        if (data.getClubIwdsa() ==1){
            chkIWDSA.setSelected(true);
        }else{
            chkIWDSA.setSelected(false);
        }

        if (data.getClubSwift() ==1){
            chkSWIFT.setSelected(false);
        }else{
            chkSWIFT.setSelected(false);
        }

        if (data.getClubOther() ==1){
            chkOtherClub.setSelected(false);
        }else{
            chkOtherClub.setSelected(false);
        }

        if (data.getGraduated() ==1){
            chkGraduated.setSelected(false);
        }else{
            chkGraduated.setSelected(false);
        }
    }

    public void reset() {
        txtBroncoNum.setText("");
        txtLName.setText("");
        txtFName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        cboStanding.setSelectedIndex(0);
        txaInterests.getText();
        cboMajor.setSelectedIndex(0);
        cboMinor.setSelectedIndex(0);
        cboQuarter.setSelectedIndex(0);
        txtLastCis.getText();
        chkRelocate.setSelected(false);
        chkMISSA.setSelected(false);
        chkFAST.setSelected(false);
        chkIWDSA.setSelected(false);
        chkSWIFT.setSelected(false);
        chkOtherClub.setSelected(false);
        chkGraduated.setSelected(false);
    }

    @Action
    public void launchInternshipAssign() {
        String message;
        AssignStudentToInternship frame = new AssignStudentToInternship();
        if (newStudent == null) {
            message = "Please enter Student data and Save";
            JOptionPane.showMessageDialog(frame, message);
        } else {
            frame.loadStudent(newStudent);
            frame.setVisible(true);
        }


    }
}
