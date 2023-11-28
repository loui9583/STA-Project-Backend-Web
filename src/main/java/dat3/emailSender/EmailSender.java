package dat3.emailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailSender {

    /*Add this dependency to pom.xml
    *
    *    <dependency>
            <groupId>com.sun.mail</groupId>
            <artifactId>jakarta.mail</artifactId>
            <version>1.6.7</version>
        </dependency>
    *
    * */

    /*TODO
             Hvis det skal bruges rigtigt skal vi
             bruge smtp fra STA's rigtige mail
          */
    public void sendContactEmail(
            String userContactMail, String emailContent) {

        String companyMail = System.getenv("companyMail");
        String companyPassword = System.getenv("companyPassword");

        // Set properties for the mail session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(companyMail, companyPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's email address
            message.setFrom(new InternetAddress(companyMail));

            // Set the recipient's email address (the company's email)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(companyMail));

            // Set the email subject
            message.setSubject("User Contact Form Submission");

            // Set the email content

            message.setText(emailContent);

            // Set the "Reply-To" header to the user's email address
            message.setReplyTo(new Address[]{new InternetAddress(userContactMail)});

            // Send the email to the company
            Transport.send(message);

            System.out.println("Email sent successfully to the company!");

            // Send a confirmation email to the user
            sendConfirmationEmail(companyMail, companyPassword, userContactMail, emailContent);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void sendConfirmationEmail(String companyMail, String companyPassword, String to, String originalEmailContent) {
        // Set properties for the mail session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(companyMail, companyPassword);
            }
        });

        try {
            // Create a MimeMessage object for the confirmation email
            Message confirmationMessage = new MimeMessage(session);

            // Set the sender's email address
            confirmationMessage.setFrom(new InternetAddress(companyMail));

            // Set the recipient's email address (the user's email)
            confirmationMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set the email subject for the confirmation email
            confirmationMessage.setSubject("Confirmation Email");

            // Set the email content for the confirmation email
            String confirmationEmailContent = "Thank you for contacting us. We have received your message and will get back to you soon.\n" +
                    "Here is the information you submitted:\n" + originalEmailContent;
            confirmationMessage.setText(confirmationEmailContent);

            // Send the confirmation email to the user
            Transport.send(confirmationMessage);

            System.out.println("Confirmation email sent successfully to the user!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
