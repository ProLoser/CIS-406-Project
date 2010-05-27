/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditUserPanel.java
 *
 * Created on May 12, 2010, 2:46:18 PM
 */

package cis406.security;

import cis406.CisComboBox;
import cis406.CisPanel;
import cis406.Database;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Raf
 */
public class EditUserPanel extends javax.swing.JPanel implements CisPanel {

    /** Creates new form EditUserPanel */
    public EditUserPanel() {
        initComponents();

        if (!(cboUsername.getItemCount() < 1)){
            try {
                ResultSet rs = Database.execute("select * from users where user_name = '" + cboUsername.getSelectedItem().toString()+ "'");
                while (rs.next()) {
                    txtFirstName.setText(rs.getString("first_name"));
                    txtLastName.setText(rs.getString("last_name"));
                    txtAnswer.setText(rs.getString("answer"));
                    ddlStatus.setSelectedIndex(Integer.parseInt(rs.getString("status")));
                    ddlSecurityLevel.setSelectedIndex(Integer.parseInt(rs.getString("clearance")));

                    // find user's security question and select it from the combo box
                    ResultSet rsSecurityQuestion = Database.execute("select question from question_key where question_key_id = " + rs.getInt("question_key_id"));
                    while (rsSecurityQuestion.next()) {
                        HashMap questions = new HashMap();

                        for (int i = 0; i < ddlSecurityQuestions.getItemCount(); i++) {
                            questions.put(i, ddlSecurityQuestions.getItemAt(i).toString());
                        }

                        for (int i = 0; i < questions.size(); i++) {
                            if (questions.get(i).equals(rsSecurityQuestion.getString("question"))) {
                                ddlSecurityQuestions.setSelectedIndex(i);
                            }
                        }
                    }

                    
                    if (ddlSecurityLevel.getSelectedIndex() == 0) {
                        ddlStatus.setEnabled(false);
                        ddlSecurityLevel.setEnabled(false);

                        if (Integer.parseInt(cis406.MainApp.loginResult[2]) > 0) {
                            txtPassword1.setEnabled(false);
                            txtPassword2.setEnabled(false);
                            txtFirstName.setEnabled(false);
                            txtLastName.setEnabled(false);
                            ddlSecurityQuestions.setEnabled(false);
                            txtAnswer.setEnabled(false);
                        }
                    }
                    else {
                        ddlStatus.setEnabled(true);
                        ddlSecurityLevel.setEnabled(true);
                        txtPassword1.setEnabled(true);
                        txtPassword2.setEnabled(true);
                        txtFirstName.setEnabled(true);
                        txtLastName.setEnabled(true);
                        ddlSecurityQuestions.setEnabled(true);
                        txtAnswer.setEnabled(true);
                    }
                }

            } catch (Exception e) {
                System.out.println("Could not execute query");
                System.out.println(e.getMessage());
            }
        }
    }
 public void clickNew() {
        clickReset();
    }

    public void clickSave() {
        // convert passwords character array to string
        String firstPassword = "";
        for (int i = 0; i < txtPassword1.getPassword().length; i++){
            firstPassword += txtPassword1.getPassword()[i];
        }
        String secondPassword = "";
        for (int i = 0; i < txtPassword2.getPassword().length; i++){
            secondPassword += txtPassword2.getPassword()[i];
        }

        if (!firstPassword.equals("")) {
            if (firstPassword.equals(secondPassword)){
                if (User.checkPassword(txtPassword1.getPassword(), cboUsername.getSelectedItem().toString())) {
                    User user = new User();

                    user.setUsername(cboUsername.getSelectedItem().toString());
                    user.setStatus(ddlStatus.getSelectedIndex());
                    user.setSecurityLevel(ddlSecurityLevel.getSelectedIndex());
                    user.setPassword(txtPassword1.getPassword());
                    user.setfName(txtFirstName.getText());
                    user.setlName(txtLastName.getText());
                    user.setSecurityAnswer(txtAnswer.getText());
                    user.setSecurityQuestion(ddlSecurityQuestions.getSelectedItem().toString());

                    user.updateUser();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "The passwords you entered do not match.");
            }
        }
        else {
            User user = new User();

            user.setUsername(cboUsername.getSelectedItem().toString());
            user.setStatus(ddlStatus.getSelectedIndex());
            user.setSecurityLevel(ddlSecurityLevel.getSelectedIndex());
            user.setfName(txtFirstName.getText());
            user.setlName(txtLastName.getText());
            user.setSecurityAnswer(txtAnswer.getText());
            user.setSecurityQuestion(ddlSecurityQuestions.getSelectedItem().toString());

            user.updateUser();
        }

    }

    public void clickLoad() {

    }

    public void clickDelete() {
      
    }

    public void clickReset() {
        cboUsername.setSelectedIndex(-1);
        txtPassword1.setText("");
        txtPassword2.setText("");
        ddlStatus.setSelectedIndex(0);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAnswer.setText("");
        ddlSecurityLevel.setSelectedIndex(0);
        ddlSecurityQuestions.setSelectedIndex(0);
    }

    public void clickBrowsing() {
//        clickClear();
//        String userID = SelectUserDialog.getValue();
//
//        if (Integer.parseInt(userID) > -1) {

//        }

    }

    public void clickEditing() {

    }

    public void clickCancel() {
    }

    public void switchTo(String actionCommand) {
        cboUsername.setModel(new CisComboBox("users", "user_name"));


    }

    public Boolean switchAway() {
        return true;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        lblConfPass = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        ddlSecurityQuestions = new javax.swing.JComboBox();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        cboUsername = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        ddlStatus = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        ddlSecurityLevel = new javax.swing.JComboBox();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(EditUserPanel.class);
        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        txtFirstName.setName("txtFirstName"); // NOI18N

        txtAnswer.setName("txtAnswer"); // NOI18N

        lblConfPass.setText(resourceMap.getString("lblConfPass.text")); // NOI18N
        lblConfPass.setName("lblConfPass"); // NOI18N

        lblPassword.setText(resourceMap.getString("lblPassword.text")); // NOI18N
        lblPassword.setName("lblPassword"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        usernameLabel.setText(resourceMap.getString("usernameLabel.text")); // NOI18N
        usernameLabel.setName("usernameLabel"); // NOI18N

        ddlSecurityQuestions.setModel(new CisComboBox("question_key", "question"));
        ddlSecurityQuestions.setName("ddlSecurityQuestions"); // NOI18N

        lblFirstName.setText(resourceMap.getString("lblFirstName.text")); // NOI18N
        lblFirstName.setName("lblFirstName"); // NOI18N

        lblLastName.setText(resourceMap.getString("lblLastName.text")); // NOI18N
        lblLastName.setName("lblLastName"); // NOI18N

        txtLastName.setName("txtLastName"); // NOI18N

        cboUsername.setModel(new CisComboBox("users", "user_name"));
        cboUsername.setName("cboUsername"); // NOI18N
        cboUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsernameActionPerformed(evt);
            }
        });

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        ddlStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Enabled", "Disabled (unsuccessful logins)" }));
        ddlStatus.setName("ddlStatus"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentHidden(evt);
            }
        });

        jSeparator2.setName("jSeparator2"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtPassword1.setName("txtPassword1"); // NOI18N

        txtPassword2.setName("txtPassword2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        ddlSecurityLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Coordinator", "Assistant" }));
        ddlSecurityLevel.setName("ddlSecurityLevel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(ddlSecurityQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblFirstName)
                                            .addComponent(lblLastName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLastName)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(63, 63, 63))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblConfPass))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(usernameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboUsername, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ddlSecurityLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ddlStatus, 0, 178, Short.MAX_VALUE)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(ddlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ddlSecurityLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfPass)
                    .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlSecurityQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1ComponentHidden

    private void cboUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsernameActionPerformed
        try {
            ResultSet rs = Database.execute("select * from users where user_name = '" + cboUsername.getSelectedItem().toString()+ "'");
            while (rs.next()) {
                txtFirstName.setText(rs.getString("first_name"));
                txtLastName.setText(rs.getString("last_name"));
                txtAnswer.setText(rs.getString("answer"));
                ddlStatus.setSelectedIndex(Integer.parseInt(rs.getString("status")));
                ddlSecurityLevel.setSelectedIndex(Integer.parseInt(rs.getString("clearance")));

                // find user's security question and select it from the combo box
                ResultSet rsSecurityQuestion = Database.execute("select question from question_key where question_key_id = " + rs.getInt("question_key_id"));
                while (rsSecurityQuestion.next()) {
                    HashMap questions = new HashMap();

                    for (int i = 0; i < ddlSecurityQuestions.getItemCount(); i++) {
                        questions.put(i, ddlSecurityQuestions.getItemAt(i).toString());
                    }

                    for (int i = 0; i < questions.size(); i++) {
                        if (questions.get(i).equals(rsSecurityQuestion.getString("question"))) {
                            ddlSecurityQuestions.setSelectedIndex(i);
                        }
                    }
                }
                
                if (ddlSecurityLevel.getSelectedIndex() == 0) {
                    ddlStatus.setEnabled(false);
                    ddlSecurityLevel.setEnabled(false);

                    if (Integer.parseInt(cis406.MainApp.loginResult[2]) > 0) {
                        txtPassword1.setEnabled(false);
                        txtPassword2.setEnabled(false);
                        txtFirstName.setEnabled(false);
                        txtLastName.setEnabled(false);
                        ddlSecurityQuestions.setEnabled(false);
                        txtAnswer.setEnabled(false);
                    }
                }
                else {
                    ddlStatus.setEnabled(true);
                    ddlSecurityLevel.setEnabled(true);
                    txtPassword1.setEnabled(true);
                    txtPassword2.setEnabled(true);
                    txtFirstName.setEnabled(true);
                    txtLastName.setEnabled(true);
                    ddlSecurityQuestions.setEnabled(true);
                    txtAnswer.setEnabled(true);
                }
            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cboUsernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboUsername;
    private javax.swing.JComboBox ddlSecurityLevel;
    private javax.swing.JComboBox ddlSecurityQuestions;
    private javax.swing.JComboBox ddlStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblConfPass;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

}
