/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import java.util.HashMap;

/**
 *
 * @author Raf
 */
public class User {

    public static HashMap hmUser = new HashMap();
    int securityLevel;
    String fName;
    String lName;
    String email;
    String password;
    String username;
    int status;
    int id;


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

    public String getEmail() {
        return email;
    }
    public int getStatus(){
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

    public void addUser() {

        hmUser.put("user_id", id);
        hmUser.put("username", username);
        hmUser.put("password", password);
        hmUser.put("first_name", fName);
        hmUser.put("last_name", lName);
        hmUser.put("clearance", Integer.toString(securityLevel));
        hmUser.put("email", email);
        hmUser.put("status", status);

        Database.write("User", hmUser);
    }

    public static void deleteUser(int user_id) {
        Database.executeWrite("DELETE FROM user WHERE user_id = '" + user_id + "'");
    }

    public void updateUser() {
        String hash = "";
        try {
            hash = byteArrayToHexString(computeHash(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.executeWrite("UPDATE user SET password = '" +
        hash + "', status = '" + status + "', first_name = '" + fName +
         "', last_name = '" + lName + "', clearance = '" + securityLevel +
         "', email = '" + email + "', status = '" + status + "', username = '" +
        username + "' WHERE user_id = '" + id + "'");
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

}