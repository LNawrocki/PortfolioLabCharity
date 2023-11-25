package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

import java.security.Principal;

public interface UserService {

    User getUserByEmail(String email);
}
