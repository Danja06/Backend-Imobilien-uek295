package ch.noseryoung.immobilien.domain.request;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RequestServiceImpl implements RequestService{
    private RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request create(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request acceptedStatus(Status ACCEPTED, UUID id) {
        return null;
    }

    @Override
    public Request deniedStatus(Status DENIED, UUID id) {
        return null;
    }
}
