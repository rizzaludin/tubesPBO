/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author lutfi
 */
public class sandemail {
     public static void sendEmail(String reception, String directory, String subjek ) throws Exception{
     Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String email = "penyimpananudin@gmail.com";
        String password = "rizzaludin1227";

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email,password);
                    }
                });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(reception));
            message.setSubject(subjek);

            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart attachFile = new MimeBodyPart();
            attachFile.attachFile(directory);
            
            multipart.addBodyPart(attachFile);
            
            message.setContent(multipart);
            
            Transport.send(message);
            System.out.println("Mail sent successfully!!!");

        
    }

}
