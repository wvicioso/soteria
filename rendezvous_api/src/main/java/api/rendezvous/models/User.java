package api.rendezvous.models;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)             //Should use Sequence for better performance
    private long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePic;     // is a url
//    private String password;
    @ManyToOne
    private School school;

    public User() {

    }
    public User(long id, String userName, String firstName, String lastName, String email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String userName, String firstName, String lastName, String school_email, School school) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = school_email;
        this.school = school;
    }

    public long getUserId() {
        return id;
    }

    public void setUser_id(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setSchool_email(String email) {
        this.email = email;
    }

    public String getProfile_pic() {
        return profilePic;
    }

    public void setProfile_pic(String profilePic) {
        this.profilePic = profilePic;
    }

    public School getSchool() {
        return this.school;
    }

    public void setSchoolID(School school) {
        this.school = school;
    }
}
