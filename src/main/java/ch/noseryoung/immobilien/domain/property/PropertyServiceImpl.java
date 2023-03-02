package ch.noseryoung.immobilien.domain.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository){ this.propertyRepository = propertyRepository; }
    private Logger LOGGER = LoggerFactory.getLogger(PropertyServiceImpl.class);
    @Override
    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property findByName(String name) {
        Optional<Property> optionalProperty= propertyRepository.findAllByName(name);
        if (optionalProperty.isPresent()){
            return optionalProperty.get();
        }
        throw new NoSuchElementException("User with Firstname "+name+" does not exist");
    }
    @Override
    public Property findByCanton(String canton) {
        Optional<Property> optionalProperty= propertyRepository.findAllByCanton(canton);
        if (optionalProperty.isPresent()){
            return optionalProperty.get();
        }
        throw new NoSuchElementException("no properties in canton "+canton+" where found");
    }

    @Override
    public Property findById(UUID propertyId) {
        Optional<Property> optionalProperty= propertyRepository.findById(propertyId);
        if (optionalProperty.isPresent()){
            return optionalProperty.get();
        }
        throw new NoSuchElementException("User with id "+propertyId+" does not exist");
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }
}
