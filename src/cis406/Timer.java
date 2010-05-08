
/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * from http://www.rgagnon.com/javadetails/java-0106.html
 */
public class Timer {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static void Timer2() {


        try {
            String str = now();//date-time with the pattern "yyyy-M-d-k-m"
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-M-d k:m:s");
            java.util.Date date = formatter.parse(str);
            java.util.Timer timer = new java.util.Timer();
            long target = date.getTime();//target date-time in Milliseconds
            Task0 task = new Task0(target);
            timer.schedule(task, 0L, 1000L);
        } catch (Exception e) {
        }
    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());

    }
}

class Task0 extends java.util.TimerTask {

    long targ;
    Integer logOff = 600;

    Task0(long target) {// constructor
        this.targ = target;
    }
    private int n = Integer.MAX_VALUE;

//run method..
    public void run() {
        //System.out.println("remaining seconds:");
        n = (int) ((this.targ - System.currentTimeMillis()) / (1000L) + logOff);
        System.out.println(String.valueOf(n));
        if (n <= 0) {
            try {
                System.out.println("Time is up!");
                System.exit(0);

                // ..Do something useful..
                this.cancel();
                // System.exit(0);
            } catch (java.lang.RuntimeException ex) {
                throw ex;
            }
        }//end of if
    }
}
