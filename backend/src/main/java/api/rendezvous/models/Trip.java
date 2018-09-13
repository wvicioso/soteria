package api.rendezvous.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    String tripDate;

    @ManyToOne
    Station startStation;

    @ManyToOne
    Station endStation;

    @ManyToMany
    List<User> users = new ArrayList<User>();

    public Trip() {
    }

    public Trip(String tripDate) {
        this.tripDate = tripDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
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

//    public List<Long> getUsers() {
//        List<Long> userids = new ArrayList<Long>();
//        for(User user : users) {
//            userids.add(user.getUserId());
//        }
//        return userids;
//    }

    public void setUsers(List<User> users) {
        this.users.addAll(users);
    }

    public void setUser(User user) {
        this.users.add(user);
    }
}
