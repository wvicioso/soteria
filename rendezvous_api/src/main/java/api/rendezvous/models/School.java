package api.rendezvous.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;
    private String schoolName;
    private Double latitude;
    private Double longitude;

    public static final long BARUCH_ID = 1;        // baruch's id
    public static final long CITY_ID = 2;          // city's id


    public School() {

    }

    public School(String address, String schoolName, Double latitude, Double longitude) {
        this.address = address;
        this.schoolName = schoolName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
