package ch.noseryoung.immobilien.domain.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user);
    User findById(UUID userId);
    User findByFirstname(String firstname);
    List<User> findAll();
}
