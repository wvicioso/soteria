package api.rendezvous.service;

import api.rendezvous.models.Station;
import api.rendezvous.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StationService {

//    @Autowired
//    private StationFake stationrepository;

    @Autowired
    private StationRepository stationrepository;

    public Collection<Station> getAllStations() {
        return this.stationrepository.findAll();
    }

    public Optional<Station> getStationById(long station_id) {
        return this.stationrepository.findById(station_id);
    }
}
