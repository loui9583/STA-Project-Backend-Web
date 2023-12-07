package dat3.project.emailSender;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sendEmail")
public class EmailSenderController {

    EmailSender emailSender = new EmailSender();

    @PostMapping("/user-email/{userContactMail}/email-content/{mailContent}/customer-name/{customerName}")
    public String sendMail(@PathVariable String userContactMail, @PathVariable String mailContent, @PathVariable String customerName){

        emailSender.sendContactEmail(userContactMail,mailContent,customerName);

        return "Email sent successfully to " + userContactMail;
    }
}
