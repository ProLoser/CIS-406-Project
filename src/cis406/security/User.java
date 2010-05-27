/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.security;

import cis406.Database;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Raf
 */
public class User {

    int securityLevel;
    String fName;
    String lName;
    String password = "";
    String username;
    String security_answer = "";
    int question_id;
    int status;
    int id;

    public User(int securityLevel, String fName, String lName,
            String password, String username, int status) {
        this.securityLevel = securityLevel;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.username = username;
        this.status = status;

    }

    public User() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return id;
    }

    public void setUserID(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSecurityAnswer() {
        return security_answer;
    }

    public void setSecurityAnswer(String answer) {
        this.security_answer = answer;
    }

    public String getSecurityQuestion() {
        return security_answer;
    }

    public void setSecurityQuestion(String question) {
        int id = 0;
        try {
            ResultSet rs = Database.execute("select question_key_id from question_key where question = '" + question + "'");

            while (rs.next()) {
                id = rs.getInt("question_key_id");
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
        this.question_id = id;
    }

    public void setPassword(char[] password) {;
        String strPassword = "";
        for (int i = 0; i < password.length; i++){
            strPassword += password[i];
        }
        String hash = "";
        try {
            hash = byteArrayToHexString(computeHash(strPassword));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.password = hash;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    // </editor-fold>

    /**
     * Use this method to create a new user in the database
     * after using the set methods in this class to add user
     * information
     */
    public void addUser() {
        if (!exists(username)) {
            try {
                Database.executeWrite("INSERT INTO users (first_name, user_name, status, last_name, clearance, password) VALUES ('" + fName + "', '" + username + "', " + 1 + ", '" + lName + "', " + securityLevel + ", '" + byteArrayToHexString(computeHash("P@ssw0rd")) + "')");
                SecurityLog.addEntry("User created: " + username + ".");
                JOptionPane.showMessageDialog(null, "User created successfully.");
            } catch (Exception e) {
                System.out.println("Failed to add the user");
                System.out.println(e.getMessage());
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Username already exists.");
        }
    }

    /**
     * Update row in the database for the user you just instantiated
     * after using the set methods in this class to add user
     * information
     */
    public void updateUser() {
        if (!password.isEmpty()) {
            Database.executeWrite("UPDATE users SET password = '"
                    + password + "', status = " + status + ", first_name = '" + fName
                    + "', last_name = '" + lName + "', clearance = " + securityLevel
                    + ", question_key_id = " + question_id + ", answer = '" + security_answer + "' WHERE user_name = '" + username + "'");
            SecurityLog.addEntry("Password and user information updated for " + username + ".");
        }
        else {
            Database.executeWrite("UPDATE users SET status = " + status + ", first_name = '" + fName
                    + "', last_name = '" + lName + "', clearance = " + securityLevel
                    + ", question_key_id = " + question_id + ", answer = '" + security_answer + "' WHERE user_name = '" + username + "'");
            SecurityLog.addEntry("User information updated for " + username + ".");
        }
    }

    public void newUserUpdate(String user_name, String answer) {
        Database.executeWrite("UPDATE users SET password = '" + password
                + "', question_key_id = " + question_id + ", answer = '"
                + answer + "', has_logged_on = 1 WHERE user_name = '" + user_name + "'");
    }

    /**
     * Checks if a user has every logged on
     * @param username Username to check
     * @return Boolean that represents whether they have ever logged on
     */
    public static boolean firstLogon(String username) {
        boolean firstLogon = false;

        if (exists(username)) {
            try {
                ResultSet rs = Database.execute("select has_logged_on from users where user_name = '" + username + "'");

                while (rs.next()) {
                    if (rs.getInt("has_logged_on") == 0) {
                        firstLogon = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed to add the user");
                System.out.println(e.getMessage());
            }
        }
        return firstLogon;
    }

    /**
     * Disable or enable a user (you shouldn't delete a user ever)
     * @param username The user_name in the users database that you want to change the status of
     * @param value 0 for disable, 1 for enable, 2 for disabled for too many unsuccessful login attempts
     */
    public static void changeStatus(String username, int value){
        Database.executeWrite("update users set status = " + value + " where user_name = '" + username + "'");
    }

    public static byte[] computeHash(String x) throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    public static boolean login(String username, String password) {
        String hash = "";
        Boolean result = false;

        if (User.getFailedLogins(username) > Integer.parseInt(Settings.load()[0]) - 1){
            return false;
        }

        try {
            hash = byteArrayToHexString(computeHash(password));
            Database db = new Database("users");
            db.and("user_name", username);
            db.and("password", hash);
            ResultSet rs = db.select();
            //ResultSet rs = Database.execute("select * from users where user_name = '" + username + "' and password = '" + hash + "'");
            while (rs.next()) {
                result = true;
                User.resetFailedLogons(username);
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static int getSecurityClearance(String username){
        int clearance = 0;

        try
        {
            ResultSet rs = Database.execute("select clearance from users where user_name = '" + username + "'");
            while (rs.next())
            {
                clearance = rs.getInt("clearance");
            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }

        return clearance;
    }

    public static void failedLogin(String username){
        int failedLogins = getFailedLogins(username) + 1;
        int allowedAttempts = Integer.parseInt(Settings.load()[0]);

        if (failedLogins < allowedAttempts){
        Database.executeWrite("update users set failed_logon_attempts = " + failedLogins + " where user_name = '" + username + "'");
        JOptionPane.showMessageDialog(null, "You have " + failedLogins + " failed logins, after " + allowedAttempts + " your account will be disabled");
        }
        else {
            Database.executeWrite("update users set failed_logon_attempts = " + failedLogins + "where user_name = '" + username + "'");
            User.changeStatus(username, 2);

            if (failedLogins == allowedAttempts){
                SecurityLog.addEntry("User (" + username + ") disabled for failed logon attempts (" + failedLogins + ").");
            }
            
            JOptionPane.showMessageDialog(null, "You have " + failedLogins + " failed login attempts and your account has been disabled, contact the administrator.");
        }
    }

    public static int getFailedLogins(String username){
        int failedLogonAttempts = 0;
        try
        {
            ResultSet rs = Database.execute("select failed_logon_attempts from users where user_name = '" + username + "'");
            while (rs.next())
            {
                failedLogonAttempts = rs.getInt("failed_logon_attempts");
                System.out.println(failedLogonAttempts);
            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }

        return failedLogonAttempts;
    }
    /**
     *
     * @param username
     */
    public static void resetFailedLogons(String username) {
        Database.executeWrite("update users set failed_logon_attempts = 0 where user_name = '" + username + "'");
    }

    /**
     * Check if a user_name is present in the users table
     * @param username The user_name in the users table you want to check for
     * @return Returns true or false based on whether the user exists
     */
    public static boolean exists(String username){
        boolean userExists = false;
        try
        {
            ResultSet rs = Database.execute("select users_id from users where user_name = '" + username + "'");
            while (rs.next())
            {
                userExists = true;
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }

        return userExists;
    }

    /**
     *
     * @param username The username you want to look up the status for
     * @return Returns an integer for a users status.  0 for disabled, 1 for
     * enabled, 2 for disabled because of unsuccessful login attempts
     */
    public static int getStatus(String username) {
        try
        {
            ResultSet rs = Database.execute("select status from users where user_name = '" + username + "'");
            while (rs.next())
            {
                int status = rs.getInt("status");
                if (status == 2) {
                    return 2;
                }
                else if (status == 1) {
                    return 1;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static boolean checkPassword(char[] password, String username) {
        boolean result = false;
        int requiredLength = Integer.parseInt(Settings.load()[3]);

        // convert password character array to string
        String strPassword = "";
        for (int i = 0; i < password.length; i++){
            strPassword += password[i];
        }


        // Make sure password meets requirements
        String lowercase = "((?=.*[a-z]).{" + requiredLength + ",})";
        String uppercase = "((?=.*[A-Z]).{" + requiredLength + ",})";
        String numbers = "((?=.*\\d).{" + requiredLength + ",})";
        String complexchars = "((?=.*[\\s.,?!:;()\\[\\]{}<>/|\\\\+-=*@#$%&_~'^\"]).{" + requiredLength + ",})";
        Integer complexityCount = 0;

        if (strPassword.matches(lowercase)) { complexityCount++; }
        if (strPassword.matches(uppercase)) { complexityCount++; }
        if (strPassword.matches(numbers)) { complexityCount++; }
        if (strPassword.matches(complexchars)) { complexityCount++; }

        if (complexityCount < 3)
        {
            JOptionPane.showMessageDialog(null, "Change your password, it doesn't meet CSU Pomona's password complexity requirements");
        }
        else if (!strPassword.equals(username)) {
            result = true;
        }

        return result;
    }
}
