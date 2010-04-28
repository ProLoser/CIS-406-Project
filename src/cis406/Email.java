/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

/**
 *
 * @author Dean Sofer
 */
public class Email {

    ///////////// CONFIGURATION OPTIONS ///////////////
    private final static boolean debug = false;
    private final static String host = "smtp";
    private final static String from = "carlin@csupomona.edu";


    public static void send(String recipients[], String subject, String message) throws MessagingException {
        send(recipients, subject, message, from);
    }

    public static void send(String recipients[], String subject, String message, String from) throws MessagingException {

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", host);

        // create some properties and get the default Session
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);


        // Optional : You can also set your custom headers in the Email if you Want
        //lolmsg.addHeader("MyHeaderName", "myHeaderValue");

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }
}
