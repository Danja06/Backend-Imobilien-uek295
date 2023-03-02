package ch.noseryoung.immobilien.domain.request;

import java.util.UUID;

public interface RequestService{
    Request create(Request request);
    Request acceptedStatus(Status ACCEPTED, UUID id);
    Request deniedStatus(Status DENIED, UUID id);

}
