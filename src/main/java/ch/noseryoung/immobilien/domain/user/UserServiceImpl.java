package ch.noseryoung.immobilien.domain.user;

import ch.noseryoung.immobilien.domain.role.Role;
import ch.noseryoung.immobilien.domain.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService{
    private RoleService roleService;
    private UserRepository userRepository;

    public UserServiceImpl(RoleService roleService, UserRepository userRepository) {
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User create(User user) {
        if (user.getEmail().matches("(.)*@noseryoung.com")) {
            user.setRole(roleService.findByRole("Agent"));
        } else {
            user.setRole(roleService.findByRole("Client"));
        }
        return userRepository.save(user);
    }

    @Override
    public User findByFirstname(String firstname) {
        Optional<User> optionalUser=userRepository.findByFirstname(firstname);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new NoSuchElementException("User with Firstname "+firstname+" does not exist");
    }

    @Override
    public User findById(UUID userId) {
        Optional<User> optionalUser=userRepository.findById(userId);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new NoSuchElementException("User with id "+userId+" does not exist");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

