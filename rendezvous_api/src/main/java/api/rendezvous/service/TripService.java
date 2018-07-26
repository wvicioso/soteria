package api.rendezvous.service;

import api.rendezvous.models.Trip;
import api.rendezvous.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TripService {

//    @Autowired
//    @Qualifier("FakeData")
//    private TripDao triprepository;

    @Autowired
    @Qualifier("MySql")
    private TripRepository triprepository;


    public Collection<Trip> getAllTrips() {
        return this.triprepository.findAll();
    }

    public Optional<Trip> getTripById(long trip_id) {
        return this.triprepository.findById(trip_id);
    }

    public void editTrip(Trip trip) {
        this.triprepository.save(trip);
    }

    public void insertTrip(Trip trip) {
        this.triprepository.save(trip);
    }

}
