package ch.noseryoung.immobilien.domain.request;

import ch.noseryoung.immobilien.domain.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RequestRepository extends JpaRepository<Request, UUID> {

    Optional<Request> findAllByProperty(Property property);
}
