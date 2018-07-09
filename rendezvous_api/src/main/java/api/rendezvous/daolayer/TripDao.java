package api.rendezvous.daolayer;

import api.rendezvous.models.Trip;

import java.util.Collection;

public interface TripDao {
    Collection<Trip> getAllTrips();

    Trip getTripById(long trip_id);

    void editTrip(Trip trip);

    void insertTrip(Trip trip);
}
