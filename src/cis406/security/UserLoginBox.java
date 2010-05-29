/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserLoginBox.java
 *
 * Created on May 13, 2010, 1:56:19 PM
 */

package cis406.security;

import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author qwerty
 */
public class UserLoginBox extends javax.swing.JDialog {

    private static String[] result = new String[3];
    private static String[] userInfo;

    /**
     * Creates new form UserLoginBox
     */
    public UserLoginBox(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        btnLogin.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        pwdPassword = new javax.swing.JPasswordField();
        btnRecoverPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(UserLoginBox.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtUsername.setText(resourceMap.getString("txtUsername.text")); // NOI18N
        txtUsername.setName("txtUsername"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(UserLoginBox.class, this);
        btnLogin.setAction(actionMap.get("clickLogin")); // NOI18N
        btnLogin.setText(resourceMap.getString("btnLogin.text")); // NOI18N
        btnLogin.setName("btnLogin"); // NOI18N

        pwdPassword.setText(resourceMap.getString("pwdPassword.text")); // NOI18N
        pwdPassword.setName("pwdPassword"); // NOI18N

        btnRecoverPassword.setAction(actionMap.get("clickRecoverPassword")); // NOI18N
        btnRecoverPassword.setText(resourceMap.getString("btnRecoverPassword.text")); // NOI18N
        btnRecoverPassword.setName("btnRecoverPassword"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRecoverPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdPassword)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnRecoverPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserLoginBox dialog = new UserLoginBox(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Action
    public void clickLogin() {
        getInputs();
        if (User.login(userInfo[0], userInfo[1])) {
            if (User.firstLogon(userInfo[0])) {
                if (!(FirstTimeUserBox.updateNewUser(userInfo[0]))) {
                    return;
                }
            }

            result[0] = "true";
            result[1] = userInfo[0];
            result[2] = Integer.toString(User.getSecurityClearance(userInfo[0]));
            this.dispose();
        } else {
            if (User.exists(userInfo[0])){
                User.failedLogin(userInfo[0]);
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed to login. Please try again.");
            }
        }
    }

    @Action
    public void clickRecoverPassword() {
        String username = txtUsername.getText().toLowerCase();

        if (!username.isEmpty()) {
            if (User.exists(username)) {
                if (!User.firstLogon(username)) {
                    if (RecoverPasswordBox.recoverPassword(username)) {
                        JOptionPane.showMessageDialog(null, "Your password has been changed successfully.");

                        pwdPassword.setText("");
                    }
                }
                else {JOptionPane.showMessageDialog(null, "You can't recover your password if you haven't logged in before.  The default password is P@ssw0rd.");}
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You must enter your username to recover your password");
        }
    }

    /**
     * retrieves and parses user login credentials from view
     * @return
     */
    private void getInputs() {
        char[] password = pwdPassword.getPassword();
        String strPassword = "";
        for (int i = 0; i < password.length; i++){
            strPassword += password[i];
        }
        userInfo = new String[2];
        userInfo[0] = txtUsername.getText().toLowerCase();
        userInfo[1] = strPassword;
    }

    /**
     * Renders login box and returns to app success or failure boolean
     * @return
     */
    public static String[] login() {

        UserLoginBox loginDialog = new UserLoginBox(new javax.swing.JFrame(), true);
        loginDialog.setVisible(true);
        //attempt to login

        //get user security clearance for result string array



        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRecoverPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
