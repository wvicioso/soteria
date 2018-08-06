package api.rendezvous.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "School")
public class School implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @OneToMany
    private List<Station> stations = new ArrayList<Station>();

    public School() { }

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
