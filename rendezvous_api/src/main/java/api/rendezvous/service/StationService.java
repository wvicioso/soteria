package api.rendezvous.service;

import api.rendezvous.daolayer.StationDB;
import api.rendezvous.models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StationService {

    @Autowired
    private StationDB stationdao;

    public Collection<Station> getAllStations() {
        return this.stationdao.getAllStations();
    }

    public Station getStationById(long station_id) {
        return this.stationdao.getStationById(station_id);
    }
}
