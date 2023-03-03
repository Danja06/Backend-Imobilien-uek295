package ch.noseryoung.immobilien.domain.application;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {
    Application create(UUID userId, UUID propertyId);
    Application acceptedStatus(UUID userId, UUID applicationId);
    Application deniedStatus(UUID userId,  UUID applicationId);
    Application getApplicationById(UUID applicationId);
}
