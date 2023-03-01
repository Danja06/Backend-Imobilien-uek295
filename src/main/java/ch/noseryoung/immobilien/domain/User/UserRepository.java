package ch.noseryoung.immobilien.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByFirstname(String firstname);
    Optional<User> findByEmail(String email);
}
