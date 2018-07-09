package api.rendezvous.service;

import api.rendezvous.daolayer.TripDB;
import api.rendezvous.daolayer.TripDao;
import api.rendezvous.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TripService {

    @Autowired
    @Qualifier("FakeData")
    private TripDao tripservice;

    public Collection<Trip> getAllTrips() {
        return this.tripservice.getAllTrips();
    }

    public Trip getTripById(long trip_id) {
        return this.tripservice.getTripById(trip_id);
    }

    public void editTrip(Trip trip) {
        this.tripservice.editTrip(trip);
    }

    public void insertTrip(Trip trip) {
        this.tripservice.insertTrip(trip);
    }

}
