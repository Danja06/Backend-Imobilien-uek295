package ch.noseryoung.immobilien.domain.application;

public enum Status {
    ACCEPTED("accepted"),   // Status accepted
    DENIED("denied"),       // Status denied
    NEW("new");             //Status new

    private final String status;// Private final Object. Enum shouldn't be changed

    Status(String status) {
        this.status = status;
    }//Status constructor

    public String getStatus() {
        return status;
    }//Status Setter
}
