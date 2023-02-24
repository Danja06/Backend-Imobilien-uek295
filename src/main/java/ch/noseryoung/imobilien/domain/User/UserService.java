package ch.noseryoung.imobilien.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user);
    User findByFirstname(String firstname);
    User findById(UUID id);
    User findByEmail(String Email);
    List<User> findAll();
}
