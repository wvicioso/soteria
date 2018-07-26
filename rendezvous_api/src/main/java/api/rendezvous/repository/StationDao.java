package api.rendezvous.repository;

import api.rendezvous.models.Station;

import java.util.Collection;

public interface StationDao {
    Collection<Station> findAll();

    Station findById(long station_id);
}
