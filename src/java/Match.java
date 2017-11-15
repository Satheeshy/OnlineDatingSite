
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yadavas9800
 */
public class Match {
    // same interest people Reverser Search
    private ArrayList<FriendList> getMyInterestMatchingFriends;
    //search people who matches preferences Mutual match
    private ArrayList<FriendList> getMatchByPreferences;
    //poeple who liked your profile,who seen ur profile
    private ArrayList<FriendList> getFriendViewedMyProfile;
    //match people based on infromation given by person...location,age,zipcode,male or female
    private ArrayList<FriendList> getByLocationAge;
    private ArrayList<FriendList> getDiscover;

    public Match(ArrayList<FriendList> getMyInterestMatchingFriends, ArrayList<FriendList> getMatchByPreferences, ArrayList<FriendList> getFriendViewedMyProfile ,ArrayList<FriendList> getDiscover) {
        this.getMyInterestMatchingFriends = getMyInterestMatchingFriends;
        this.getMatchByPreferences = getMatchByPreferences;
        this.getFriendViewedMyProfile = getFriendViewedMyProfile;
        this.getDiscover = getDiscover;
    }

    public ArrayList<FriendList> getGetMyInterestMatchingFriends() {
        return getMyInterestMatchingFriends;
    }

    public void setGetMyInterestMatchingFriends(ArrayList<FriendList> getMyInterestMatchingFriends) {
        this.getMyInterestMatchingFriends = getMyInterestMatchingFriends;
    }

    public ArrayList<FriendList> getGetMatchByPreferences() {
        return getMatchByPreferences;
    }

    public void setGetMatchByPreferences(ArrayList<FriendList> getMatchByPreferences) {
        this.getMatchByPreferences = getMatchByPreferences;
    }

    public ArrayList<FriendList> getGetFriendViewedMyProfile() {
        return getFriendViewedMyProfile;
    }

    public void setGetFriendViewedMyProfile(ArrayList<FriendList> getFriendViewedMyProfile) {
        this.getFriendViewedMyProfile = getFriendViewedMyProfile;
    }

    public ArrayList<FriendList> getGetByLocationAge(String username) {
        
        this.getByLocationAge = Database.getByLocationAge(username);
        return this.getByLocationAge;
    }

    public ArrayList<FriendList> getGetByLocationAge() {
        return getByLocationAge;
    }

    public void setGetByLocationAge(ArrayList<FriendList> getByLocationAge) {
        this.getByLocationAge = getByLocationAge;
    }

    public ArrayList<FriendList> getGetDiscover() {
        return getDiscover;
    }

    public void setGetDiscover(ArrayList<FriendList> getDiscover) {
        this.getDiscover = getDiscover;
    }

    
    
}

  