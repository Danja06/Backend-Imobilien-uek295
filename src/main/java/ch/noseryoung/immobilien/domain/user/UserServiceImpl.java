package ch.noseryoung.immobilien.domain.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User create(User property) {
        return userRepository.save(property);
    }

    @Override
    public User findByFirstname(String firstname) {
        Optional<User> optionalUser=userRepository.findByFirstname(firstname);
        if (optionalUser.isPresent()){
            optionalUser.get();
        }
        throw new NoSuchElementException("User with Firstname "+firstname+" does not exist");
    }

    @Override
    public User findById(UUID id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if (optionalUser.isPresent()){
            optionalUser.get();
        }
        throw new NoSuchElementException("User with id "+id+" does not exist");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
