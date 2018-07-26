package api.rendezvous.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long school_id;
    private String address;
    private String school_name;
    private String email_suffix;
    private Double latitude;
    private Double longitude;
//    private Set<String> stations;

    public static final long BARUCH_ID = 1;        // baruch's id
    public static final long CITY_ID = 2;          // city's id


    public School() {

    }

    public School(String address, String school_name, String email_suffix, Double latitude, Double longitude) {
        this.address = address;
        this.school_name = school_name;
        this.email_suffix = email_suffix;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail_suffix() {
        return email_suffix;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
