package api.rendezvous.models;

public interface UserDef {

    public long getUserId();
    public String getUserName();
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public String getProfilePic();

    public long setUserId();
    public void setUserName(String userName);
    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setEmail(String email);
    public void setProfilePic(String profilePic);

}
