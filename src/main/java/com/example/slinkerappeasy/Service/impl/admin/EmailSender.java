package com.example.slinkerappeasy.Service.impl.admin;

import com.example.slinkerappeasy.Bean.Client;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private static final String host = "smtp.zoho.com";
    private static final String username = "slinker.eysi@chifaaconseil.com";
    private static final String password = "m9kV DKtf AvTM";

    public void sendScrapingCompletionEmail(Long id) {
        Client to = clientAdminService.findById(id);
        String from = username;

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getEmail()));
            message.setSubject("SLINKER_APP - Scraping Completion");
            message.setText("Dear Client,\n\nThe scraping process has been completed.\n\nSlinkerAdmin");

            Transport.send(message);
            System.out.println("The message has been sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendSubscriptionExpiryReminderEmail(Long id) {
        Client to = clientAdminService.findById(id);
        String from = username;

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getEmail()));
            message.setSubject("SLINKER_APP - Subscription Expiry Reminder");
            message.setText("Dear Client,\n\nYour subscription is about to expire. Please renew your subscription.\n\nSlinkerAdmin");

            Transport.send(message);
            System.out.println("The message has been sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    @Autowired
    public ClientAdminServiceImpl clientAdminService;
}


