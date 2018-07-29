package api.rendezvous.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String tripDate;
    String startStation;
    String endStation;

    @ManyToMany
    List<User> users;

    public Trip() {
    }

    public Trip(String tripDate, String start_station, String endStation) {
        this.tripDate = tripDate;
        this.startStation = start_station;
        this.endStation = endStation;
        this.users = new ArrayList<User>();
    }

    public Trip(long id, String tripDate, String startStation, String endStation, List<User> users) {
        this.id = id;
        this.tripDate = tripDate;
        this.startStation = startStation;
        this.endStation = endStation;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users.addAll(users);
    }

    public void setUser(User user) {
        this.users.add(user);
    }

}
