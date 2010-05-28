/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.security;

import java.sql.ResultSet;

/**
 *
 * @author elunoysolo
 */
public class Settings {

    int password_length;
    int session_timeout;
    int password_interval;
    int loginAttempts;

    public Settings() {
        try {
            ResultSet rs = cis406.Database.execute("select * from configuration");
            while (rs.next()) {
                this.password_length = rs.getInt("min_password_length");
                this.session_timeout = rs.getInt("session_timeout");
                this.password_interval = rs.getInt("change_password_interval");
                this.loginAttempts = rs.getInt("logon_attempts");
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public void setSession_timeout(int session_timeout) {
        this.session_timeout = session_timeout;
    }

    public int getSession_timeout() {
        return session_timeout;
    }

    public int getPassword_interval() {
        return password_interval;
    }

    public int getPassword_length() {
        return password_length;
    }

    public void setPassword_length(int password_length) {
        this.password_length = password_length;
    }

    public void setPassword_interval(int password_interval) {
        this.password_interval = password_interval;
    }

    public void setLoginAttempts(int attempts){
        this.loginAttempts = attempts;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }
    // </editor-fold>

    public void save() {
        try {
            cis406.Database.executeWrite("update configuration set min_password_length = "
                                + password_length + ", session_timeout = " + session_timeout
                                + ", change_password_interval = " + password_interval
                                + ", logon_attempts = " + loginAttempts);
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
    }
}
