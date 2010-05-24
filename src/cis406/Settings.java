/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.io.*;

/**
 *
 * @author elunoysolo
 */
public class Settings {

    int password_length;
    int session_timeout;
    int password_interval;
    int loginAttempts;

    public Settings(int password_length, int session_timeout, int password_interval, int attempts) {
        this.password_length = password_length;
        this.session_timeout = session_timeout;
        this.password_interval = password_interval;
        this.loginAttempts = attempts;
    }

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

    public void save() {
        Writer output = null;
        File file = new File("internapp.config");
        try {
                output = new BufferedWriter(new FileWriter(file));
                output.write(loginAttempts + ","
                                + session_timeout + ","
                                + password_interval + ","
                                + password_length);
                output.close();
                System.out.println("Your file has been written");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String[] load() {
        String[] config = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("internapp.config"));
            String str;
            while ((str = in.readLine()) != null) {
                config = str.split(",");
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return config;
    }
}
