package api.rendezvous.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "User")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)             //Should use Sequence for better performance
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

//    @Column(nullable = false)
    @JsonIgnore
    @Transient
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

//    @Column(name = "confirmation_token")
    @JsonIgnore
    @Transient
    private String confirmationToken;

    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    public User() {
    }

    public User(String firstName, String lastName, String school_email, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = school_email;
        this.school = school;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() { return enabled; }

    public void setEnabled(boolean value) { this.enabled = value; }

    public School getSchool() { return this.school; }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getConfirmationToken() { return confirmationToken; }

    public void setConfirmationToken(String confirmationToken) { this.confirmationToken = confirmationToken; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
