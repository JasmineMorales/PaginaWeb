/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ali
 */
@Service
public class EmailService{
	
	@Autowired
        private JavaMailSender javaMailSender;

	public void sendEmail(String email, String telefono, String factura, String razon) {
            System.out.println("sending");

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("cuenteretes.url@gmail.com");
            msg.setTo("cuenteretes.url@gmail.com");

            msg.setSubject("SOLICITUD DE DEVOLUCION: " + factura);
            msg.setText("FACTURA: "+ factura+ "\nCORREO: " + email + "\nRAZON: " + razon);

            javaMailSender.send(msg);
            
            msg = new SimpleMailMessage();
            msg.setFrom("cuenteretes.url@gmail.com");
            msg.setTo(email);

            msg.setSubject("SOLICITUD DE DEVOLUCION: " + factura);
            msg.setText("FACTURA: "+ factura+ "\nCORREO: " + email + "/\nRAZON: " + razon);

            javaMailSender.send(msg);
        }	
}