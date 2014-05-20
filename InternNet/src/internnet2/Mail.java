/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internnet2;

import domein.StageOpdracht;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author laurens
 */
public class Mail {
   
    public void MailToBedrijf(String Email,StageOpdracht stageopdracht){
      // Recipient's email ID needs to be mentioned.
      String to = Email;

      // Sender's email ID needs to be mentioned
      String from = "CodeConstructors@gmail.com";

      // Assuming you are sending email from localhost
      String host = "587";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
     properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     properties.put("mail.smtp.host", "smtp.gmail.com");
     properties.put("mail.smtp.port", "587");
     properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
     properties.put("mail.user", "CodeConstructors@gmail.com");
     properties.put("mail.password","CodeConstructors123");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties, new GmailAuthenticator(from,"CodeConstructors123"));
      

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("StageOpdracht goedgekeurd");

         // Now set the actual message
         message.setText("Beste "+stageopdracht.getStageMentor()+",\n" +
"Het ingediend voorstel van stage-opdracht met titel "+stageopdracht.getNaam()+" is goedgekeurd voor academiejaar "+stageopdracht.getAcademieJaar()+".\n" +
"Dit wil zeggen dat uw stage-opdracht in de lijst van goedgekeurde stages aan de studenten zal worden getoond.\n" +
"Indien er studenten geïnteresseerd zijn in uw stage, dan zullen zij contact met uw bedrijf opnemen om te solliciteren.\n" +
"Alvast veel succes met de sollicitaties en nogmaals hartelijk dank voor het indienen van uw stage-opdracht."
                 + "Met vriendelijke groeten,\n" +
"Anneleen Bekkens\n" +
"Lector Informatica\n" +
"Stagecoördinator Toegepaste Informatica\n" +
"---------------------------------------------------------\n" +
"HoGent\n" +
"Hogeschool Gent\n" +
"Faculteit Bedrijf en Organisatie\n" +
"Campus Aalst\n" +
"Arbeidstraat 14\n" +
"BE-9300 Aalst\n" +
"anneleen.bekkens@hogent.be\n" +
"www.hogent.be/fbo");

         // Send message
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
    public void MailToBedrijfAfgekeurd(String Email,String Reden,StageOpdracht stageopdracht){
      // Recipient's email ID needs to be mentioned.
      String to = Email;

      // Sender's email ID needs to be mentioned
      String from = "CodeConstructors@gmail.com";

      // Assuming you are sending email from localhost
      String host = "587";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
     properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     properties.put("mail.smtp.host", "smtp.gmail.com");
     properties.put("mail.smtp.port", "587");
     properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
     properties.put("mail.user", "CodeConstructors@gmail.com");
     properties.put("mail.password","CodeConstructors123");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties, new GmailAuthenticator(from,"CodeConstructors123"));
      

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("StageOpdracht goedgekeurd");

         // Now set the actual message
         message.setText("Beste "+stageopdracht.getStageMentor()+" ,\n" +
"Het ingediend voorstel van stage-opdracht met titel "+stageopdracht.getNaam()+" is niet goedgekeurd voor academiejaar "+stageopdracht.getAcademieJaar()+".\n" +
"Reden hiervoor is: "+Reden+" \n" +
"Met vriendelijke groeten,\n" +
"Anneleen Bekkens\n" +
"Lector Informatica\n" +
"Stagecoördinator Toegepaste Informatica\n" +
"---------------------------------------------------------\n" +
"HoGent\n" +
"Hogeschool Gent\n" +
"Faculteit Bedrijf en Organisatie\n" +
"Campus Aalst\n" +
"Arbeidstraat 14\n" +
"BE-9300 Aalst\n" +
"anneleen.bekkens@hogent.be\n" +
"www.hogent.be/fbo");

         // Send message
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}

