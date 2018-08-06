package api.rendezvous.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Train implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean inService;

    public Train() {}

    public Train(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() { return name; }

    public boolean isInService() { return inService; }
}
