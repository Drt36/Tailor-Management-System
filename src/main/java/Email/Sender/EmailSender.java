/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email.Sender;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dharm
 */
public class EmailSender {
    //welcome email sender
    public void welcomeEmailSender(String useremail,String fullname,String userpassword){
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Welcome "+fullname);

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for choosing Tailor Management System With Design Recommendation made by DRT .Now welcome to TMSWDR family."
                      +"<br> Email: "+useremail
                      +"<br> Password: "+userpassword
                      +"<br> Please Do not share this credentials with others and reset the password as soon as possible."
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //otp code email sender
    public void otpCodeEmailSender(String user_email,String fullname,String otpcode){
         // Recipient's email ID needs to be mentioned.
        String to =user_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Reset Password Code!!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Use this code to reset your password"
                      +"<br> Code: <b>"+otpcode+"<b>"
                      +"<br>This code will expire in 2 minutes.!"
                      +"<br> Please Do not share this credentials with others and reset the password as soon as possible."
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //Password reset email sender
    public void resetPasswordEmailSender(String user_email,String fullname,String password){
         // Recipient's email ID needs to be mentioned.
        String to =user_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Reseted Password !!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>This is your new reseted password"
                      +"<br> Password: <b>"+password+"<b>"
                      +"<br> Please Do not share this credentials with others and change the password as soon as possible."
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //blocked message email sender
    public void blockedEmailSender(String useremail,String fullname){
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Sorry!Account Blocked!!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for being part of Tailor Management System With Design Recommendation made by DRT ."
                      + "<br>Now You are blocked from TMSWDR"
                      + " because of unusal activities.You can not use system from Now. "
                      + "<br>Thank YoU!"
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //unblocked message emailsender
    public void unBlockedEmailSender(String useremail,String fullname){
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Hurray!Account Unblocked!!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Your unusal activities are reviewed by admin and decided to unblock ."
                      + "<br>Now You are Unblocked from TMSWDR"
                      + " You can use system from Now. Hope you will not do same mistake again."
                      + "<br> Thank You!"
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //user removed email sender
    public void removededEmailSender(String useremail,String fullname){
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Sorry!Account Deleted permanently!!!");

            // actual message
             message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for being part of Tailor Management System With Design Recommendation made by DRT ."
                      + "<br>Now You are removed permanently from TMSWDR"
                      + "<br>because of repeated unusal activities.You can not use system from Now."
                      + "<br> Thank you!"
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
   
      
    //welcome customer message sender
    public void welcomeCustomerEmailSender(String customer_email,String fullname,String username){
         // Recipient's email ID needs to be mentioned.
        String to =customer_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Welcome "+fullname);

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for choosing Tailor Management System With Design Recommendation made by DRT .Now welcome to TMSWDR family."
                      +"<br> Username: "+username
                      +"<br> Please Do not share this credentials with others."
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //customer removed message sender
    public void customerRemovedEmailSender(String customeremail,String fullname){
         // Recipient's email ID needs to be mentioned.
        String to =customeremail;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Sorry!Data Deleted permanently!!!");

            // actual message
             message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for being part of Tailor Management System With Design Recommendation made by DRT ."
                      + "<br>Now You are removed permanently from TMSWDR"
                      + "<br>as per your request.Your data will not available from Now."
                      + "<br> Thank you!"
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    
    //Order status changed message sender
    public void orderStatusEmailSender(String customer_email,String fullname,String order_id,String status){
         // Recipient's email ID needs to be mentioned.
        String to =customer_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Order has been"+status);

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>Thank you for ordering with us.Your Order has been "+status +"."
                      +"<br>Order Id: "+order_id
                      +"<br> Please Do not share this credentials with others."
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
  
        
    //paid amount updated message sender
    public void orderPaymentEmailSender(String customer_email,String fullname,String order_id,Float remainingamount,Float paidamount){
         // Recipient's email ID needs to be mentioned.
        String to =customer_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Paid amount Updated!!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>The paid amount has been updated."
                      +"<br>Order Id: "+order_id
                      +"<br>Amount Paid:"+paidamount
                       +"<br>Remaining Amount:"+remainingamount
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
 
        
    //salary paid amount updated message sender
    public void salaryPaymentEmailSender(String staff_email,String fullname,Float paidamount){
         // Recipient's email ID needs to be mentioned.
        String to =staff_email;

        // Sender's email ID needs to be mentioned
        String from = "tmswdr@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tmswdr@gmail.com", "admin123456789*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Paid Salary Updated!!!");

            // actual message
            message.setContent(
              "<h4>Dear "+fullname+","
                      +"<br>The paid salary amount has been updated."
                      +"<br>Amount Paid:"+paidamount
                      + "<br> Regards,<br>TMSWDR</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
