/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

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

    public void add() {
        Database db = new Database("users");
        db.addField("user_id", id);
        db.addField("username", username);
        db.addField("password", password);
        db.addField("first_name", fName);
        db.addField("last_name", lName);
        db.addField("clearance", securityLevel);
        db.addField("email", email);
        db.addField("status", status);

        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the user");
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int userId) {
        Database.delete("user", userId);
    }

    public void update() {
        String hash = "";
        try {
            hash = byteArrayToHexString(computeHash(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.executeWrite("UPDATE user SET password = '"
                + hash + "', status = '" + status + "', first_name = '" + fName
                + "', last_name = '" + lName + "', clearance = '" + securityLevel
                + "', email = '" + email + "', status = '" + status + "', username = '"
                + username + "' WHERE user_id = '" + id + "'");
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
