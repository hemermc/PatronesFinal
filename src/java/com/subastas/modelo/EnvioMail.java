package com.subastas.modelo;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo_12
 */
public class EnvioMail {
    
    private final String USER_REMITENTE = "proyectopatrones2019@gmail.com";
    private final String PASS_REMITENTE = "patrones2019";
    private String destinatario;

    public void envioSingleCorreo(String destinatario) {
        this.destinatario = "juan.moscosoch@gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");//El servidor SMTP de Google
        properties.put("mail.smtp.user", USER_REMITENTE);
        properties.put("mail.smtp.clave", PASS_REMITENTE);
        properties.put("mail.smtp.auth", "true");//Usar autenticación mediante usuario y clave
        properties.put("mail.smtp.starttls.enable", "true");//Para conectar de manera segura al servidor SMTP
        properties.put("mail.smtp.port", "587");//El puerto SMTP seguro de Google
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(USER_REMITENTE));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.destinatario));
            message.setSubject("Notificación - Actualización Subasta");
            message.setText("Su puja ha sido superada. Actualice su puja si no quiere perder la subasta");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", USER_REMITENTE, PASS_REMITENTE);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioMail.class.getName()+"\n").log(Level.SEVERE, "Error al enviar el correo electrónico\n", ex);
        }
    }
}
