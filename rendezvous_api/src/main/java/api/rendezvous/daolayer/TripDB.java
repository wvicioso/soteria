package api.rendezvous.daolayer;

import api.rendezvous.models.Trip;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakeData")
public class TripDB implements TripDao {

    private static Map<Long, Trip> trips;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    static {
        trips = new HashMap<Long, Trip>() {
            {
                put(1L, new Trip(1L, (new Date()).toString(), "lexington", "the mall"));
                put(2L, new Trip(2L, (new Date()).toString(), "beach", "home"));
                put(3L, new Trip(3L, (new Date()).toString(), "work", "hamptons"));
            }
        };
    }

    @Override
    public Collection<Trip> getAllTrips() {
        return this.trips.values();
    }

    @Override
    public Trip getTripById(long trip_id) {
        return this.trips.get(trip_id);
    }

    @Override
    public void editTrip(Trip trip) {
        if(trips.containsKey(trip.getTrip_id())) {
            trips.put(trip.getTrip_id(), trip);
        }
    }

    @Override
    public void insertTrip(Trip trip) {
        trips.put(trip.getTrip_id(), trip);
    }

}
