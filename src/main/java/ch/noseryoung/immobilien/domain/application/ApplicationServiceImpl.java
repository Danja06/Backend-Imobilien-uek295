package ch.noseryoung.immobilien.domain.application;

import ch.noseryoung.immobilien.domain.property.Property;
import ch.noseryoung.immobilien.domain.property.PropertyService;
import ch.noseryoung.immobilien.domain.user.User;
import ch.noseryoung.immobilien.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private UserService userService;
    private PropertyService propertyService;
    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, UserService userService, PropertyService propertyService) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @Override
    public Application create(UUID userId, UUID propertyId) {
        User user = userService.findById(userId);
        Property property = propertyService.findById(propertyId);
        boolean multipleApplications = false;
        for(Application newApplication: applicationRepository.findAllByProperty(property)){
                multipleApplications = newApplication.getUser().equals(user);
        }
        // if user.getRole -> role.getRole = Client. User pulls Role from role and if its Client it's true
        if (user.getRole().getRole().equals("Client") && !multipleApplications) {
            Application application = new Application();
            application.setUser(user);
            application.setProperty(property);
            application.setStatus(Status.NEW);
            return applicationRepository.save(application);
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Application acceptedStatus(UUID userId, UUID applicationId) {
        User user = userService.findById(userId);
        Application application = getApplicationById(applicationId);
        // if user.getRole -> role.getRole = Client. User pulls Role from role and if its Agent it's true & application should have the same name and property as user
        if (user.getRole().getRole().equals("Agent") && application.getProperty().getUser().equals(user)){
            for (Application newApplication: applicationRepository.findAllByProperty(application.getProperty())){
                newApplication.setStatus(Status.DENIED);
                applicationRepository.save(application);
            }
                application.setStatus(Status.ACCEPTED);
                    return applicationRepository.save(application);
            }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }



    @Override
    public Application deniedStatus(UUID userId, UUID applicationId) {
        User user = userService.findById(userId);
        Application application = getApplicationById(applicationId);

        if (user.getRole().getRole().equals("Agent") && application.getProperty().getUser().equals(user)){
            application.setStatus(Status.DENIED);
            return applicationRepository.save(application);
            }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }

    @Override
    public Application getApplicationById(UUID applicationId) {
        Optional<Application> optionalApplication=applicationRepository.findById(applicationId);
        if(optionalApplication.isPresent()) {
            return optionalApplication.get();
        }
        throw new NoSuchElementException("Application with id "+applicationId+" does not exist");
    }


}

