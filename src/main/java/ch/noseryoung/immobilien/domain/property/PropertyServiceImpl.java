package ch.noseryoung.immobilien.domain.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private Logger LOGGER = LoggerFactory.getLogger(PropertyServiceImpl.class);
    @Override
    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property findByName(String name) {
        Optional<Property> optionalProperty= propertyRepository.findByName(name);
        if (optionalProperty.isPresent()){
            optionalProperty.get();
        }
        throw new NoSuchElementException("User with Firstname "+name+" does not exist");
    }

    @Override
    public Property findById(UUID id) {
        Optional<Property> optionalProperty= propertyRepository.findById(id);
        if (optionalProperty.isPresent()){
            optionalProperty.get();
        }
        throw new NoSuchElementException("User with id "+id+" does not exist");
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }
}
