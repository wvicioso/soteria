package api.rendezvous.daolayer;

import api.rendezvous.models.Station;

import java.util.Collection;

public interface StationDao {
    Collection<Station> getAllStations();

    Station getStationById(long station_id);
}
