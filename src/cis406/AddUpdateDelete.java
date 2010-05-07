/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.util.*;
import java.sql.ResultSet;

/**
 *
 * @author Raf/Robert
 * The password encryption came from http://www.rgagnon.com/javadetails/java-0400.html
 */
public class AddUpdateDelete {

    public static HashMap hmUser = new HashMap();

    public static void addUser(User user) {

        hmUser.put("user_id", user.getUserID());
        hmUser.put("username", user.getUsername());
        hmUser.put("password", user.getPassword());
        hmUser.put("first_name", user.getfName());
        hmUser.put("last_name", user.getlName());
        hmUser.put("clearance", Integer.toString(user.getSecurityLevel()));
        hmUser.put("email", user.getEmail());
        hmUser.put("status", "1");

        Database.write("User", hmUser);
    }

    public static void deleteUser(int user_id) {
        Database.executeWrite("DELETE FROM user WHERE user_id = '" + user_id + "'");
    }

    public static void updateUser(User user) {
        String hash = "";
        try {
         
            hash = byteArrayToHexString(AddUpdateDelete.computeHash(user.getPassword()));


         
        } catch (Exception e) {
            e.printStackTrace();
        }
         Database.executeWrite("UPDATE user SET password = '" +
        hash + "', status = '" + user.getStatus() + "', first_name = '" + user.getfName() +
         "', last_name = '" + user.getlName() + "', clearance = '" + user.getSecurityLevel() +
         "', email = '" + user.getEmail() + "', status = '" + user.getStatus() + "', username = '" +
        user.getUsername() + "' WHERE user_id = '" + user.getUserID() + "'");
        //Goes into user settings tab
//       
//        
        //end
    }
    // belongs in user settings

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {

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
