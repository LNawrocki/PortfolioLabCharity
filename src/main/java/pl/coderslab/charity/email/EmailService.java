package pl.coderslab.charity.email;

public interface EmailService {
    String sendMail(EmailDetails emailDetails);

    String sendActivationEmail(String email, String uuid);
}
