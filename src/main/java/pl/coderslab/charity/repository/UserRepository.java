package pl.coderslab.charity.repository;

import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);

//    User getByUsername(String username);
}
