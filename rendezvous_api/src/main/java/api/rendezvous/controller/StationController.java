package api.rendezvous.controller;

import api.rendezvous.models.Station;
import api.rendezvous.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Station> getAllStations() {
        return this.stationService.getAllStations();
    }

    @RequestMapping(value = "/{station_id}")
    public Optional<Station> getStationById(@PathVariable long station_id) {
        return this.stationService.getStationById(station_id);
    }


}
