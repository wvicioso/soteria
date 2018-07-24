package api.rendezvous.models;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             //Should use Sequence for better performance
    private long user_id = ThreadLocalRandom.current().nextLong(1000000);  //temporary key generation

    private String userName;
    private String firstName;
    private String lastName;
    private String school_email;
    private String profile_pic;     // is a url
    private long schoolID;          //foreign key
//    private String password;

    public User() {

    }
    public User(String userName, String firstName, String lastName, String school_email, long schoolID) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school_email = school_email;
        this.schoolID = schoolID;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public String getSchool_email() {
        return school_email;
    }

    public void setSchool_email(String school_email) {
        this.school_email = school_email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public long getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(long schoolID) {
        this.schoolID = schoolID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;


        return user != null ? user_id == user.user_id : null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school_email=" + school_email +
                '}';
    }
}
