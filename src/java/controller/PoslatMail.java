/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Favak
 */
public class PoslatMail {

    private String from;
    private String to;
    private String subject;
    private String text;

    public PoslatMail(String from, String to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public void send() {

        Properties props = new Properties();
        
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.test.cz");
        props.put("mail.smtp.port", "587");       
        
        Session mailSession = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("noreply@test.cz", "testtest");
			}
		  });        
       
        // String bodyText = "This is a important message with attachment";
        // String filename = "message.pdf";
        //Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);

        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {           
            message.setFrom(fromAddress);
            message.setRecipient(RecipientType.TO, toAddress);
            message.setSubject(subject, "utf-8");
            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text, "text/html; charset=utf-8");

            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            //Transport transport = mailSession.getTransport();

            //final String SMTPlogin = "fakturace";
            //final String SMTPheslo = "faktura123";
            // connect to server
            //transport.connect(host, login, heslo);

           /* Authenticator auth = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTPlogin, SMTPheslo);
                }
            };
            mailSession = Session.getInstance(props, auth);*/

           // transport.connect(SMTPlogin, SMTPheslo);

            mailSession.setDebugOut(System.out);

            Transport.send(message); // Transport

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    //public void vytvorPrilohu(String reportSource, ShoppingCart kosik) {

    public void vytvorPrilohu(String reportSource, int kosik) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("cislo_akce", kosik + "D");
            params.put("akce_id", kosik);

            /*
             * try { JasperReport jasperReport =
             * JasperCompileManager.compileReport(reportSource);
             *
             * JasperPrint jasperPrint1 = JasperFillManager.fillReport(
             * jasperReport, params, Pripojeni.con);
             * JasperExportManager.exportReportToPdfFile(jasperPrint1,
             * "objednavka.pdf"); //
             * JasperExportManager.exportReportToPdfFile(jasperPrint1,
             * HlavniRamec.loaderAdresar + HlavniRamec.oddelovac + i + ".pdf");
             *
             * } catch (JRException ex) { ex.printStackTrace();
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
