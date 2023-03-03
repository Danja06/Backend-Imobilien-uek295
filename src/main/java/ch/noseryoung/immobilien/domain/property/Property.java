package ch.noseryoung.immobilien.domain.property;

import ch.noseryoung.immobilien.domain.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "property")
public class Property {
    @Id                         //Id oder Primärschlüsser von der Tabelle
    @GeneratedValue            //wird im neuen Objekt automatisch generiert
    @UuidGenerator            //der generierte Wert ist ein Universal unique identifier
    private UUID propertyId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "size")
    private int size;
    @Column(name = "canton")
    private String canton;
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User user;


    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
