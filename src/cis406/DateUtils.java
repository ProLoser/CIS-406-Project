/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mark Lenser
 */
public class DateUtils {

    public static final String DATE_FORMAT_NOW = "yyyyMMdd";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static String nowFormatted() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        return sdf.format(cal.getTime());
    }
}
