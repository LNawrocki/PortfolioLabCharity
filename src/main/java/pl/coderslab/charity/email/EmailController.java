package pl.coderslab.charity.email;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

// Annotation
//@RestController
// Class
@Controller
@AllArgsConstructor
public class EmailController {

//    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(EmailDetails emailDetails, String name, String surname,String message) {
        emailDetails.setRecipient("test@lightnet.eu");
        emailDetails.setSubject("Wiadomość ze strony głownej Charity" + " - " + name + " " + surname);
        emailDetails.setMsgBody(message);
        String status = emailService.sendMail(emailDetails);
//        return status;
        return "redirect:/";
    }
    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestBody EmailDetails details)
//    {
//        String status
//                = emailService.sendMailWithAttachment(details);
//
//        return status;
//    }
}