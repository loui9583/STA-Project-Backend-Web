package dat3.emailSender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sendEmail")
public class EmailSenderController {

    EmailSender emailSender = new EmailSender();

    @PostMapping("/user-email/{userContactMail}/email-content/{mailContent}")
    public String sendMail(@PathVariable String userContactMail, @PathVariable String mailContent){

        emailSender.sendContactEmail(userContactMail,mailContent);

        return "Email sent successfully to " + userContactMail;
    }
}
