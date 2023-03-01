package ch.noseryoung.immobilien.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User create(User user) {
        return userRepository.save(user);
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
    public User findByEmail(String email) {
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            optionalUser.get();
        }
        throw new NoSuchElementException("");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
