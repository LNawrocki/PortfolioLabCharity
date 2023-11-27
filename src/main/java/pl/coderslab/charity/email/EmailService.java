package pl.coderslab.charity.email;

public interface EmailService {
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
//    String SendActivationEmail(String email, String uuid);

}
