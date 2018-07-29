package api.rendezvous.service;

import api.rendezvous.models.Station;
import api.rendezvous.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StationService {

    @Autowired
    @Qualifier("MySql")
    private StationRepository stationrepository;

    public Collection<Station> getAllStations() {
        return this.stationrepository.findAll();
    }

    public Optional<Station> getStationById(long station_id) {
        return this.stationrepository.findById(station_id);
    }
}
