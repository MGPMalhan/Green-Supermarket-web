/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    private static Session newSession;
    private static MimeMessage mimeMessage = null;
    private static String appPassword = "";

    public void sendEmail(String firstName, String lastName, String email, String message) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        newSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                // sender address
                return new PasswordAuthentication("", appPassword);
            }
        });

        mimeMessage = new MimeMessage(newSession);
        mimeMessage.setSubject("Green SuperMarket");
        mimeMessage.setContent("<p><b>Hello,</b></p>"
                + String.format("\"<p>You have new message from Mr/Ms <b>%s</b></p><br>"
                        + "Message: %s<br>"
                        + "My Email: %s<br>"
                        + "Best Regards", firstName + " " + lastName, message, email),
                "text/html");
        
        // reciever
        Address addressTo = new InternetAddress("");
        mimeMessage.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(mimeMessage);
    }

    public void sendOrderSuccessEmail(String name, String date, String time, String email, String orderId, double total) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        newSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", appPassword);
            }
        });

        mimeMessage = new MimeMessage(newSession);
        mimeMessage.setSubject("Green SuperMarket");
        mimeMessage.setContent(String.format("<head>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 20px auto;\n"
                + "            padding: 20px;\n"
                + "            border: 1px solid #ccc;\n"
                + "            border-radius: 8px;\n"
                + "        }\n"
                + "\n"
                + "        p {\n"
                + "            margin-bottom: 15px;\n"
                + "        }\n"
                + "\n"
                + "        h2 {\n"
                + "            color: #333;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <h2>Order Confirmation - Green SuperMarket </h2>\n"
                + "        <p>Dear %s,</p>\n"
                + "        <p>Thank you for choosing Green SuperMarket! Your order has been successfully placed, and we are currently processing it. Below are the key details:</p>\n"
                + "\n"
                + "        <!-- Order Details -->\n"
                + "        <p><strong>Order Number:</strong> %s </p>\n"
                + "        <p><strong>Order Date:</strong> %s %s</p>\n"
                + "\n"
                + "        <!-- Payment Details -->\n"
                + "        <p><strong>Total Amount:</strong> LKR %.2f</p>\n"
                + "\n"
                + "        <p>If you have any questions or concerns regarding your order, please feel free to contact our customer support team at GreenSupermarket@gmail.com or +94 72 080 6890.</p>\n"
                + "\n"
                + "        <p>Thank you once again for choosing Green Super. We appreciate your business and look forward to serving you again.</p>\n"
                + "\n"
                + "        <p>Best regards,<br>\n"
                + "        Green SuperMarket<br>\n"
                + "    </div>\n"
                + "</body>", name, orderId, date, time, total), "text/html");

        Address addressTo = new InternetAddress(email);
        mimeMessage.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(mimeMessage);
    }
    
      public void sendOrderCancelEmail(String name, String orderId, String email) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        newSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", appPassword);
            }
        });

        mimeMessage = new MimeMessage(newSession);
        mimeMessage.setSubject("Green SuperMarket");
        mimeMessage.setContent(String.format("<head>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 20px auto;\n"
                + "            padding: 20px;\n"
                + "            border: 1px solid #ccc;\n"
                + "            border-radius: 8px;\n"
                + "        }\n"
                + "\n"
                + "        p {\n"
                + "            margin-bottom: 15px;\n"
                + "        }\n"
                + "\n"
                + "        h2 {\n"
                + "            color: #333;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <h2>Order Cancellation - Green SuperMarket </h2>\n"
                + "        <p>Dear %s,</p>\n"
                + "        <p>Thank you for choosing Green SuperMarket! Your order has been successfully cancelled</p>\n"
                + "\n"
                + "        <!-- Order Details -->\n"
                + "        <p><strong>Order Number:</strong> %s </p>\n"
                + "\n"
                + "        <p>Best regards,<br>\n"
                + "        Green SuperMarket<br>\n"
                + "    </div>\n"
                + "</body>", name, orderId), "text/html");

        Address addressTo = new InternetAddress(email);
        mimeMessage.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(mimeMessage);
    }


}
