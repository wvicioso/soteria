package api.rendezvous.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Entity
public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double latitude;

    @Column(nullable = false)
    Double longitude;

    @OneToMany
    @Column(nullable = false)
    List<Train> trains = new ArrayList<Train>();

    public Station() {
    }

    public Station(String station_name, Double latitude, Double longitude) {
        this.id = id;
        this.name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Station(long id, String station_name, Double latitude, Double longitude, List<Train> trains) {
        this.id = id;
        this.name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trains = trains;
    }

    public Station(long id, String station_name, Double latitude, Double longitude, Train train) {
        this.id = id;
        this.name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trains = new ArrayList<Train>();
        this.trains.add(train);
    }

    public String getName() { return name; }

    public Double getLatitude() { return latitude; }

    public Double getLongitude() { return longitude; }

    public List<Train> getTrains() { return trains; }
}
