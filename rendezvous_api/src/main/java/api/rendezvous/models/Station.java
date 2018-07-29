package api.rendezvous.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    Double latitude;
    Double longitude;
    @OneToMany
    List<Train> trains;

    public Station() {
    }

    public Station(long id, String station_name, Double latitude, Double longitude) {
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

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Train> getTrains() { return trains; }
}
