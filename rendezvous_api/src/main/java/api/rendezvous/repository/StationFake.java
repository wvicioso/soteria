package api.rendezvous.repository;

import api.rendezvous.models.Station;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StationFake implements StationDao {

    private static Map<Long, Station> stations;

    static {
        stations = new HashMap<Long, Station>() {
            {
//                Map<Long, String> line1 = new HashMap<Long, String>();
//                line1.put(1L, "A");
//                line1.put(2L, "C");
//                line1.put(3L, "B");
//                line1.put(4L, "D");
                put(1L, new Station(1L, "145 St", 40.824783, -73.944216));
//                put(1L, new Station(1L, "145 St", line1, 40.824783, -73.944216));
//                Map<Long, String> line2 = new HashMap<Long, String>();
//                line2.put(2L, "C");
//                line2.put(3L, "B");
                put(2L, new Station(2L, "135 St",40.817894, -73.947649));
//                put(2L, new Station(2L, "135 St", line2, 40.817894, -73.947649));
            }
        };
    }

    @Override
    public Collection<Station> findAll() {
        return this.stations.values();
    }

    @Override
    public Station findById(long station_id) {
        return this.stations.get(station_id);
    }
}
