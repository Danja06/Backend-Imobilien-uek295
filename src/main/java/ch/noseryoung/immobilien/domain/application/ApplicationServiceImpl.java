package ch.noseryoung.immobilien.domain.application;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application create(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application acceptedStatus(UUID id, UUID applicationId) {
        return null;
    }

    @Override
    public Application deniedStatus(UUID id, UUID applicationId) {
        return null;
    }
}
