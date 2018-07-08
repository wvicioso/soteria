package api.rendezvous.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long school_id;
    private String address;
    private String school_name;

    public static final long BARUCH = 1;        // baruch's id
    public static final long CITY = 2;          // city's id

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail_suffix() {
        return email_suffix;
    }

    public void setEmail_suffix(String email_suffix) {
        this.email_suffix = email_suffix;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    String email_suffix;
    Double latitude;
    Double longitude;

    @ManyToMany()
    Set<String> stations;

}
