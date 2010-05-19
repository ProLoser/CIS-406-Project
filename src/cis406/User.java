/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

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
    String email;
    String password;
    String username;
    int status;
    int id;

    public User(int securityLevel, String fName, String lName, String email,
            String password, String username, int status) {
        this.securityLevel = securityLevel;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
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

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
        try {
            Database.executeWrite("INSERT INTO users (first_name, user_name, status, email, last_name, clearance, password) VALUES ('" + fName + "', '" + username + "', " + status + ", '" + email + "', '" + lName + "', " + securityLevel + ", '" + byteArrayToHexString(computeHash("P@ssw0rd")) + "')");
        } catch (Exception e) {
            System.out.println("Failed to add the user");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update row in the database for the user you just instantiated
     * after using the set methods in this class to add user
     * information
     */
    public void updateUser() {
        String hash = "";
        try {
            hash = byteArrayToHexString(computeHash(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.executeWrite("UPDATE users SET password = '"
                + hash + "', status = " + status + ", first_name = '" + fName
                + "', last_name = '" + lName + "', clearance = " + securityLevel
                + ", email = '" + email + "' WHERE user_name = '" + username + "'");
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

        if (User.getFailedLogins(username) > 2){
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

        if (failedLogins < 3){
        Database.executeWrite("update users set failed_logon_attempts = " + failedLogins + " where user_name = '" + username + "'");
        JOptionPane.showMessageDialog(null, "You have " + failedLogins + " failed logins, after 3 your account will be disabled");
        }
        else {
            Database.executeWrite("update users set failed_logon_attempts = " + failedLogins + "where user_name = '" + username + "'");
            User.changeStatus(username, 2);
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
}
