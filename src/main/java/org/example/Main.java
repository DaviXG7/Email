package org.example;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public class Main {


    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        EmailUtils.loadSession();
        new Mensagem("Teste",
                "Olha oq tive que fazer pra mandar isso kkkk" +
                "<img src=\"https://cdn.discordapp.com/attachments/1104248431200964619/1232843673939742721/image.png?ex=662aeea4&is=66299d24&hm=ebe9b2021907f10b7c144d847498182fa030bd3f73e899d0939d3bb9d75aff84&\" />" +
                "<img src=\"https://cdn.discordapp.com/attachments/1104248431200964619/1232843342015103007/image.png?ex=662aee55&is=66299cd5&hm=09a8fde97aecaa9df636135a06be16d3b0523e682629b90bdaa8a001e86ef584&\" />"
                + "Ainda anexei este arquivo").anexarArquivo("D:\\Estudos\\CursoJava\\Email\\src\\main\\java\\org\\example\\slaoq.pdf").enviarEmail("vytroquitor@gmail.com");


        System.out.println("Pronto...");
    }
}