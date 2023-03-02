package ch.noseryoung.immobilien.domain.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
    Optional<Property> findAllByCanton(String canton);
    Optional<Property> findAllByName(String name);
}
