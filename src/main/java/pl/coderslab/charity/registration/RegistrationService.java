package pl.coderslab.charity.registration;

import pl.coderslab.charity.user.User;

public interface RegistrationService {
    String saveAndSendActivationLink(User user, String password);

    String accountActivation(String uuid);
}
