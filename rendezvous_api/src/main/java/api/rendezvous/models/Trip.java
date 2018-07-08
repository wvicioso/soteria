package api.rendezvous.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trip_id;

    Date trip_date;

    @OneToOne
    Station start_station;

    @OneToOne
    Station end_station;

    @OneToMany
    Set<String> user_id;

    public Date getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(Date trip_date) {
        this.trip_date = trip_date;
    }
}
