/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AssignStudentToInternship.java
 *
 * Created on May 15, 2010, 4:18:35 PM
 */
package cis406.student;

import cis406.DateUtils;
import cis406.TableModel;
import cis406.internship.Internship;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author F-91
 */
public class AssignStudentToInternshipDialog extends javax.swing.JFrame {

    /** Creates new form AssignStudentToInternship */
    public AssignStudentToInternshipDialog() {
        initComponents();
        loadTable();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        lblAssignDate.setText(sdf.format(cal.getTime()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblBroncoNum = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAssignInternship = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblAssignDate = new javax.swing.JLabel();
        lblDateSecured = new javax.swing.JLabel();
        txtDateSecured = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        chkForCredit = new javax.swing.JCheckBox();

        jDialog1.setName("jDialog1"); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Company Name", "Internship Position", "Posted Date", "Expiration Date", "Slots Available", "Status"
            }
        ));
        reportTable.setName("reportTable"); // NOI18N
        jScrollPane1.setViewportView(reportTable);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(AssignStudentToInternshipDialog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        lblFullName.setFont(resourceMap.getFont("lblFullName.font")); // NOI18N
        lblFullName.setText(resourceMap.getString("lblFullName.text")); // NOI18N
        lblFullName.setName("lblFullName"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        lblBroncoNum.setFont(resourceMap.getFont("lblBroncoNum.font")); // NOI18N
        lblBroncoNum.setText(resourceMap.getString("lblBroncoNum.text")); // NOI18N
        lblBroncoNum.setName("lblBroncoNum"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        btnAssignInternship.setText(resourceMap.getString("btnAssignInternship.text")); // NOI18N
        btnAssignInternship.setName("btnAssignInternship"); // NOI18N
        btnAssignInternship.setNextFocusableComponent(btnCancel);
        btnAssignInternship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignInternshipActionPerformed(evt);
            }
        });

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        lblEmail.setFont(resourceMap.getFont("lblEmail.font")); // NOI18N
        lblEmail.setText(resourceMap.getString("lblEmail.text")); // NOI18N
        lblEmail.setName("lblEmail"); // NOI18N

        btnCancel.setText(resourceMap.getString("btnCancel.text")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.setNextFocusableComponent(txtDateSecured);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        lblAssignDate.setFont(resourceMap.getFont("lblAssignDate.font")); // NOI18N
        lblAssignDate.setText(resourceMap.getString("lblAssignDate.text")); // NOI18N
        lblAssignDate.setName("lblAssignDate"); // NOI18N

        lblDateSecured.setText(resourceMap.getString("lblDateSecured.text")); // NOI18N
        lblDateSecured.setName("lblDateSecured"); // NOI18N

        txtDateSecured.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M-dd-yyyy"))));
        txtDateSecured.setText(resourceMap.getString("txtDateSecured.text")); // NOI18N
        txtDateSecured.setName("txtDateSecured"); // NOI18N
        txtDateSecured.setNextFocusableComponent(chkForCredit);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        chkForCredit.setText(resourceMap.getString("chkForCredit.text")); // NOI18N
        chkForCredit.setName("chkForCredit"); // NOI18N
        chkForCredit.setNextFocusableComponent(btnAssignInternship);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssignInternship)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBroncoNum))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblDateSecured, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDateSecured)
                                        .addComponent(lblAssignDate))
                                    .addComponent(chkForCredit))))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAssignInternship, btnCancel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(lblFullName)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblEmail)
                            .addComponent(jLabel7)
                            .addComponent(lblBroncoNum)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(lblAssignDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDateSecured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateSecured, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(chkForCredit)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAssignInternship, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAssignInternship, btnCancel});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAssignInternshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignInternshipActionPerformed
        assignInternship();// TODO add your handling code here:
    }//GEN-LAST:event_btnAssignInternshipActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignInternship;
    private javax.swing.JButton btnCancel;
    private javax.swing.JCheckBox chkForCredit;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssignDate;
    private javax.swing.JLabel lblBroncoNum;
    private javax.swing.JLabel lblDateSecured;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JTable reportTable;
    private javax.swing.JFormattedTextField txtDateSecured;
    // End of variables declaration//GEN-END:variables
    StudentInternshipMgr studIntMgr = new StudentInternshipMgr();
    Student aStudent = null;
    Internship aInternship = null;

    /*Loads a student into the frame so that it can be
     * passed to the StudentInternshipMgr and loads pertinent
     * info into the dialog controls.
     */
    public void loadStudent(Student student) {
        aStudent = student;
        lblFullName.setText(aStudent.getFullName());
        lblBroncoNum.setText(Integer.toString(aStudent.getBroncoNum()));
        lblEmail.setText(aStudent.getEmail());
    }

    public void loadTable() {
        reportTable.setModel(StudentInternshipMgr.generateInternshipTable());
    }

    public Boolean save() {
        Boolean success = true;
        int record = getSelectedRow();
        if (aStudent != null & aInternship == null) {
            aInternship = new Internship(record);
        } else if (aStudent == null & aInternship != null) {
            aStudent = new Student(record);
        }
        studIntMgr.assignedInternship = aInternship;
        studIntMgr.assignedStudent = aStudent;
        if (!studIntMgr.setDateSecured(txtDateSecured.getText())) {
            lblDateSecured.setForeground(Color.RED);
            success = false;
        } else {
            lblDateSecured.setForeground(Color.BLACK);
        }
        studIntMgr.setAssignDate(lblAssignDate.getText());
        studIntMgr.setForCredit(chkForCredit.isSelected());


        if (!success) {
            JOptionPane.showMessageDialog(null, "Please check the data for errors");
            
            return success;
        } else {
            studIntMgr.assignInternship();
            return success;
        }

    }

    public int getSelectedRow() {
        int row = reportTable.getSelectedRow();
        if (row != -1) {
            return ((TableModel) reportTable.getModel()).getRowId(row);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first");
            return 0;
        }
    }

    @Action
    public void assignInternship(){
        if(save()){
            JOptionPane.showMessageDialog(null, "Internship assigned successfully");
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Failed to assign the internship");
        }
    }
}
