package com.lucca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail, String subject, String body){
        System.out.println("enter mail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("grhapp1@outlook.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        this.mailSender.send(message);
        System.out.println("Mail sent successfully");
    }
}
