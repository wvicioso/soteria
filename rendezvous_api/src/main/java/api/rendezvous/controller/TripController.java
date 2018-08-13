package api.rendezvous.controller;

import api.rendezvous.models.Trip;
import api.rendezvous.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Trip> getAllTrips() {
        return this.tripService.getAllTrips();
    }

    @RequestMapping(value = "/{trip_id}", method = RequestMethod.GET)
    public Optional<Trip> getTripById(@PathVariable long trip_id) {
        return this.tripService.getTripById(trip_id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void editTrip(@RequestBody Trip trip) {
        this.tripService.editTrip(trip);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertTrip(@RequestBody Trip trip) {
        this.tripService.insertTrip(trip);
    }
}