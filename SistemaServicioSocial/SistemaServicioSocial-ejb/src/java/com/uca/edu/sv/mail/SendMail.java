/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.mail;

import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.process.Constantes;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class SendMail implements Serializable {

    private static final Logger LOG = Logger.getLogger(SendMail.class.getName());

    @Resource(lookup = "notificacionMail", type = Session.class)
    private Session mailSession;

    @Asynchronous
    public void buildMail(String to, String template, Usuario usuario, String password) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            String body = new String(Files.readAllBytes(Paths.get(SendMail.class.getClassLoader().getResource("META-INF/".concat(template.concat(Constantes.XML))).toURI())));
            body = body.replace("#{mail.date}", format.format(new Date()));
            if (template.equals(Constantes.MAIL_USUARIO)) {
                body = body.replace("#{mail.usuario}", usuario.getCodUsuario());
                body = body.replace("#{mail.password}", password);
            } else if (template.equals(Constantes.MAIL_SOLICITUD)) {

            }
            sendMail(to, Constantes.SUBJECT, body);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error armando correo.", ex);
        }
    }

    @Asynchronous
    public void buildMail(String to, String template, Usuario usuario) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            String body = new String(Files.readAllBytes(Paths.get(SendMail.class.getClassLoader().getResource("META-INF/".concat(template.concat(Constantes.XML))).toURI())));
            body = body.replace("#{mail.date}", format.format(new Date()));
            body = body.replace("#{mail.usuario}", usuario.getCodUsuario());
            sendMail(to, Constantes.SUBJECT, body);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error armando correo.", ex);
        }
    }

    private void sendMail(String to, String subject, String body) {
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body, "utf-8", "html");
            Transport.send(message);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error enviando correo de notificacion", ex);
        }
    }

}
