package api.rendezvous.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long station_id;

    String station_name;
//    Map<Long, String> lines;
    Double latitude;
    Double longitude;

//    public Station(long station_id, String station_name, Map<Long, String> lines, Double latitude, Double longitude) {
//        this.station_id = station_id;
//        this.station_name = station_name;
//        this.lines  = lines;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }

    public Station(long station_id, String station_name, Double latitude, Double longitude) {
        this.station_id = station_id;
        this.station_name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStation_name() {
        return station_name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
