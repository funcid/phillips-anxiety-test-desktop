package me.reidj.anxietydiagnostic.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailSenderService {

    private static final String RESOURCES_PATH = "src/main/resources/mail.properties";

    private final Properties systemProperties = System.getProperties();
    private final Properties properties = loadFile(RESOURCES_PATH);

    public MailSenderService() {
        systemProperties.setProperty("mail.smtp.host", properties.getProperty("mail.host"));
        systemProperties.setProperty("mail.smtp.port", properties.getProperty("mail.port"));
        systemProperties.setProperty("mail.smtp.ssl.enable", "true");
        systemProperties.setProperty("mail.smtp.auth", "true");
    }

    public void send(String to, String subject, String text) {
        Session session = Session.getInstance(
                systemProperties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.getProperty("mail.username"), properties.getProperty("mail.password"));
                    }
                }
        );
        generateMessage(to, session, subject, text);
    }

    private void generateMessage(String to, Session session, String subject, String text) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("mail.username")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Диагностика уровня тревожности | " + subject);
            message.setText(text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Properties loadFile(String path) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
