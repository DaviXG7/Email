package org.example;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {


    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.starttls", "true");

        String mail = "xg7mails@gmail.com";
        String senha = "uma senha :D";

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
            @Override
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(mail,senha);
                    }
                });

        session.setDebug(true);

        Address[] to = InternetAddress.parse("alexmello.andrade@gmail.com");


        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("xg7mails@gmail.com"));

        message.setRecipients(Message.RecipientType.TO, to);
        message.setSubject("Olá, este é meu primeiro email eviado por código, resumindo, sou eu papai :D");
        message.setText("Meu primeiro email sendo enviado pelo java :P, se quiser eu faço um spam kkkkkkkkk");

        Transport.send(message);
        System.out.println("Pronto...");
    }
}