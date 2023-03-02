package ch.noseryoung.immobilien.domain.request;

public enum Status {
    ACCEPTED("accepted"),
    DECLINED("denied"),
    PREPARING("preparing"),
    NEW("new");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
