package dat3.project.emailSender;

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
            String userContactMail, String emailContent, String customerName) {

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
            sendConfirmationEmail(companyMail, companyPassword, userContactMail, emailContent, customerName);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void sendConfirmationEmail(String companyMail, String companyPassword, String to, String originalEmailContent, String customerName) {
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
            confirmationMessage.setSubject("Confirmation of Your Training Inquiry");

            // Set the email content for the confirmation email

            //TODO sæt logo make training simple sta osv i bunden af mailen
            String confirmationEmailContent = "<html>"
                    + "<body>"
                    + "<h2>Dear " + customerName + ",</h2>"
                    + "<p>Thank you for choosing Scandinavian Training Academy for your Typerating, LPC, or Instructor Training needs. We are thrilled to embark on this aviation journey with you!</p>"
                    + "<p>Your inquiry has been received, and our team is already working diligently to provide you with the information and guidance you need to take the next steps in your training.</p>"
                    + "<h2>What's Next?</h2>"
                    + "<p>Our dedicated team of experienced aviation professionals is here to ensure you receive the highest quality training experience. Whether you're pursuing a Typerating course, LPC, or Instructor Training, rest assured that our programs are meticulously crafted to meet the industry's demanding standards.</p>"
                    + "<h2>Personalized Service</h2>"
                    + "<p>At Scandinavian Training Academy, you are more than just a student; you are a valued member of our aviation community. Our commitment to personalized service is at the core of everything we do. From answering your inquiries to celebrating your accomplishments, we are here to support you every step of the way.</p>"
                    + "<h2>Global Reach with a Personal Touch</h2>"
                    + "<p>Despite our global presence, we pride ourselves on maintaining a personal connection with each of our students. You are not just a number; you are an integral part of our aviation family. Your success is our success, and we are dedicated to guiding you until you successfully complete your Typerating, LPC, or Instructor Training.</p>"
                    + "<h2>Stay Connected</h2>"
                    + "<p>To keep you informed and engaged throughout your training journey, we encourage you to connect with us on our social media platforms. Follow us on "
                    + "<a href='https://www.linkedin.com/company/scandinavian-training-academy' target='_blank'>LinkedIn</a>, "
                    + "<a href='https://www.facebook.com/scanditraining' target='_blank'>Facebook</a>, and "
                    + "<a href='https://www.instagram.com/scanditraining' target='_blank'>Instagram</a> for updates, success stories, and aviation insights.</p>"
                    + "<p>We look forward to helping you achieve your aviation goals and witnessing your success as you progress through our Typerating, LPC, or Instructor Training programs.</p>"
                    + "<p>Should you have any immediate questions or concerns, please do not hesitate to reply to this mail.</p>"
                    + "<p>Thank you once again for choosing Scandinavian Training Academy. Get ready for an exciting and rewarding training experience!</p>"
                    + "<p>Best Regards,</p>"
                    + "<p>Scandinavian Training Academy</p>"
                    + "</body>"
                    + "</html>";

            confirmationMessage.setContent(confirmationEmailContent, "text/html; charset=utf-8");

            // Send the confirmation email to the user
            Transport.send(confirmationMessage);

            System.out.println("Confirmation email sent successfully to the user!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
