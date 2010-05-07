/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/**
 *
 * @author qwerty
 */
public class SecurityLog {
    private String[] security_log;
    private ResultSet rs;
    private DefaultListModel security_log_model;


    public SecurityLog()
    {
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
}

