package ch.noseryoung.immobilien.domain.property;

import java.util.List;
import java.util.UUID;

public interface PropertyService {
    Property create(Property property);
    Property findById(UUID propertyId);
    Property findByName(String name);
    List<Property> findAll();
}
