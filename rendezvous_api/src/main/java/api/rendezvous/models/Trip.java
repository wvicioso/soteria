package api.rendezvous.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trip_id;
    String trip_date;
//    Station start_station;
//    Station end_station;
    String start_station;
    String end_station;
//    Set<String> user_id;

    public Trip() {
    }

    public Trip(String trip_date, String start_station, String end_station) {
        this.trip_date = trip_date;
        this.start_station = start_station;
        this.end_station = end_station;
    }

    public Trip(long trip_id, String trip_date, String start_station, String end_station) {
        this.trip_id = trip_id;
        this.trip_date = trip_date;
        this.start_station = start_station;
        this.end_station = end_station;
    }


    public long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(long trip_id) {
        this.trip_id = trip_id;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public String getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(String trip_date) {
        this.trip_date = trip_date;
    }
}
