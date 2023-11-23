package pl.coderslab.charity.service;

import pl.coderslab.charity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
//    String sendMailWithAttachment(EmailDetails details);

}
