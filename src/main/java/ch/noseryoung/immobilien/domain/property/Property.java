package ch.noseryoung.immobilien.domain.property;

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
    @Column(name = "homegate")
    private String homegate;


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

    public String getHomegate() {
        return homegate;
    }

    public void setHomegate(String homegate) {
        this.homegate = homegate;
    }
}
