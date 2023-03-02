package ch.noseryoung.immobilien.domain.request;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "request")
public class request {
    @Id
    public UUID requestId;

    @ManyToOne
    @JoinColumn(name = "property")

}
