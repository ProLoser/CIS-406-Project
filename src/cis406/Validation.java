package cis406;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mark Lenser
 */
public class Validation {
    //Validation

    public static boolean isNotEmpty(String str) {

        //It can't contain only numbers if it's null or empty...
        if (str == null || str.length() == 0) {
            return false;
        }

        return true;
    }

    public static boolean isChars(String str) {

        for (int i = 0; i < str.length(); i++) {
            //If we find a non-char character we return false.
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNums(String str) {

        for (int i = 0; i < str.length(); i++) {
            //If we find a non-char character we return false.
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isCharsNumsSpaces(String str) {

        for (int i = 0; i < str.length(); i++) {
            //If we find a non-char character we return false.
            if (!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidEmailAddress(String emailAddress) {
        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    public static boolean isDate(String date) {
        DateFormat df = new SimpleDateFormat("y-M-d");
        try {
            df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
