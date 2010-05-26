/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.security;

import cis406.Database;
import cis406.MainApp;
import java.sql.*;
import javax.swing.DefaultListModel;

/**
 * So far adds log entries for:
     * logins
     * password changed
     * system settings changed
     * new user created
     * user disabled for login attempts
     * user updated info
 * @author qwerty
 */
public class SecurityLog {
    private ResultSet rs;
    private DefaultListModel security_log_model;
    // disable security log entries by default to prevent database problems during development
    private static boolean disableUserLogEntries = true;


    public SecurityLog()
    {
    }

    public static void addEntry(String message) {
        if (!disableUserLogEntries) {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Database.executeWrite("insert into user_log (date, time, description, user_name) values ('" + now + "', '" + now + "', '" + message + "', '" + MainApp.loginResult[1] + "')");
        }
    }

    public DefaultListModel getModel()
    {
        try
        {
        rs = Database.execute("select * from user_log");
            while (rs.next())
            {
                System.out.println(rs.getString("user_log_id"));
                int index = security_log_model.getSize();
                security_log_model.add(index, rs.getString("user_log_id"));
            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }

        return security_log_model;
    }

    public String[] getUserLog(String log_id)
    {
        rs = Database.execute("select * from user_log where user_log_id = '" + log_id + "'");
        String[] log = new String[4];
        try
        {
            while (rs.next())
            {
                log[0] = log_id;
                log[1] = rs.getString("date");
                log[2] = rs.getString("description");
                log[3] = rs.getString("user_id");
            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }

        return log;
    }

    public static void setEnabled(boolean mode) {
        disableUserLogEntries = mode;
    }

    public static boolean getEnabled() {
        return disableUserLogEntries;
    }
}

