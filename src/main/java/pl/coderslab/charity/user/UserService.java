package pl.coderslab.charity.user;

public interface UserService {

    User getUserByEmail(String email);
    User getUserByUuid(String uuId);
}
