package ch.noseryoung.immobilien.domain.request;

import ch.noseryoung.immobilien.domain.property.Property;
import ch.noseryoung.immobilien.domain.user.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    public UUID requestId;

    @ManyToOne
    @JoinColumn(name = "property")
    private Property property;

    @ManyToMany(mappedBy = "requests")
    private List<User> user;
    @Column(name = "status")
    public boolean status;

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
