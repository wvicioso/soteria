package api.rendezvous.repository;

import api.rendezvous.models.Trip;

import java.util.Collection;

public interface TripDao {
    Collection<Trip> findAll();

    Trip findById(long trip_id);

    void save(Trip trip);
}
