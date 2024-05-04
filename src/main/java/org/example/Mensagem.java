package org.example;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;

public class Mensagem {

    private String assunto;
    private String mensagem;
    private Multipart multipart;

    public Mensagem(String assunto, String mensagem) {
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public Mensagem anexarArquivo(String path) {
        try {
            Multipart multipart = new MimeMultipart();

            MimeBodyPart bodyPart = new MimeBodyPart();

            File file = new File(path);

            bodyPart.attachFile(file);
            multipart.addBodyPart(bodyPart);

            this.multipart = multipart;

        } catch (Exception e) {}

        return this;

    }



    public void enviarEmail(String destinatarios) {
        try {
            Address[] to = InternetAddress.parse(destinatarios);

            Message message = new MimeMessage(EmailUtils.getSession());
            message.setFrom(new InternetAddress("xg7mails@gmail.com", "DaviXG7Mails!"));
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject(assunto);
            if (multipart != null) {

                MimeBodyPart bodyPart = new MimeBodyPart();
                bodyPart.setContent(mensagem, "text/html; charset=utf-8");
                multipart.addBodyPart(bodyPart);
                message.setContent(multipart);
                Transport.send(message);
            }
            message.setContent(mensagem, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
