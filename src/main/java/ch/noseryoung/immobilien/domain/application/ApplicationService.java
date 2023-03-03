package ch.noseryoung.immobilien.domain.application;

import java.util.UUID;

public interface ApplicationService {
    Application create(Application application);
    Application acceptedStatus(UUID id, UUID applicationId);
    Application deniedStatus(UUID id,  UUID applicationId);

}
