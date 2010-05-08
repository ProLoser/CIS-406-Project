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
public class Configuration {

    int password_length;
    int session_timeout;
    int password_interval;

    public Configuration(int password_length, int session_timeout, int password_interval) {
        this.password_length = password_length;
        this.session_timeout = session_timeout;
        this.password_interval = password_interval;
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



    static String fName = "clsFile.config";
    static String fName2 = "clsFile.config2";

    public String getVer() {
        String vVer = new String();

        java.lang.Package p = this.getClass().getPackage();
        vVer = p.getImplementationVersion();

        return vVer;
    }

    public void writeProp() throws java.lang.Exception {
        try {
            java.util.Properties vProp = new java.util.Properties();
            String tmpStr = new String();

            tmpStr = "TestApp is logsmith;aaxx";

            vProp.setProperty("orString", tmpStr);
            java.io.FileOutputStream configFile = new java.io.FileOutputStream(fName);
            vProp.storeToXML(configFile, "Configuration File");
            configFile.close();
            configFile = new java.io.FileOutputStream(fName2);
            vProp.store(configFile, "Second File");
            configFile.close();


        } catch (java.lang.Exception ex) {
            throw new java.lang.Exception("[clsTest01]" + ex.getMessage());
        }
    }

    public void readProp() throws java.lang.Exception {
        try {
            java.util.Properties vProp = new java.util.Properties();
            java.io.FileInputStream iFile = new java.io.FileInputStream(fName);

            vProp.loadFromXML(iFile);
            String tmpStr = new String();
            tmpStr = vProp.getProperty("orString");
            System.out.println("ConnString is \n" + tmpStr);

            vProp = new java.util.Properties();
            iFile = new java.io.FileInputStream(fName2);
            vProp.load(iFile);
            tmpStr = vProp.getProperty("orString");
            System.out.println("ConnString is \n" + tmpStr);

        } catch (java.lang.Exception ex) {
            throw new java.lang.Exception(ex.getMessage());
        }

    }

    public void save() {
        Writer output = null;
        File file = new File("internapp.config");
        try {
                output = new BufferedWriter(new FileWriter(file));
                output.write(password_interval + ","
                                + password_length + ","
                                + session_timeout);
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
                System.out.println(str);
                config = str.split(",");
            }
            in.close();

                System.out.println(config[1]);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return config;
    }
}
