package ch.noseryoung.immobilien.domain.application;

import ch.noseryoung.immobilien.domain.property.Property;
import ch.noseryoung.immobilien.domain.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "requests")
public class Application {
    @Id
    @GeneratedValue
    @UuidGenerator
    public UUID applicationId;

    @ManyToOne
    @JoinColumn(name = "property")
    private Property property;
    //One Property has many applications

    @ManyToMany(mappedBy = "requests")
    private List<User> user;
    //Many Users can make many Applications
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    //Status if the Application is new, accepted or denied


    //Getter and Setter

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
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

    public Status isStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
