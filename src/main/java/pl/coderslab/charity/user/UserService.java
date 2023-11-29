package pl.coderslab.charity.user;

public interface UserService {

    User getUserByEmail(String email);
    User getUserByUuid(String uuid);
    User userDataToSave(User user, String password, String uuid);

    User save(User user);
}
