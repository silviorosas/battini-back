package com.escuela.battini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail (String destino,String asunto,String texto){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("escuelabattiniapp@gmail.com");
        mensaje.setTo(destino);
        mensaje.setSubject(asunto);
        mensaje.setText(texto);

        mailSender.send(mensaje);
    }
}
