package pl.coderslab.charity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);
    User getUserByUuId(String uuId);
}
