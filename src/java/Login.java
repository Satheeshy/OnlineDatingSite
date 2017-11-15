/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Tatha
 */
@ManagedBean
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    private String username;
    private String password;
    private User loginId;
    private String friend_name;
    private User friend_id;
    private String location;
    private int startAge;
    private int endAge;
    private String zipcode;
    private String city;
    private String seekinggender;
    private String SearchName;
    private String DiscoverName;
    private boolean show;
    private ArrayList<msg> messages;
    private String typedMsg;
    private ArrayList<FriendList> friends;
    private boolean isFriend;
    private boolean edit = true;
    private boolean quicksearch;
    private ArrayList<FriendList> qsearch;

    public boolean isEdit() {
        return edit;
    }

    public ArrayList<FriendList> getQsearch() {
        return qsearch;
    }

    public void setQsearch(ArrayList<FriendList> qsearch) {
        this.qsearch = qsearch;
    }

    public void searchByquicksearch() {
        ArrayList<FriendList> friends = Database.getQuickSearch(username, seekinggender, startAge, endAge, city);
        for(FriendList f: friends){
            if(f==null){
               friends.remove(f);
            }
        }
        this.qsearch = friends;
        setQuicksearch(true);

    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void rejectFriendRequest(String friendname) {
        Database.rejectFriendRequest(username, friendname);

        ArrayList<FriendList> viewfreinds = Database.viewReceivedFriendRequest(username);
        this.loginId.setViewreceivedFriendRequest(viewfreinds);
    }

    public void acceptFriendReqest(String friendname) {
        Database.acceptFriendReqest(username, friendname);
        ArrayList<FriendList> viewfreinds = Database.viewReceivedFriendRequest(username);
        this.loginId.setViewreceivedFriendRequest(viewfreinds);
    }

    public void cancelFriendRequest(String cancelname) {
        Database.cancelFriendRequest(username, friend_name);
        ArrayList<FriendList> viewfreinds = Database.viewReceivedFriendRequest(username);
        this.loginId.setViewreceivedFriendRequest(viewfreinds);
    }

    public boolean isQuicksearch() {
        return quicksearch;
    }

    public void setQuicksearch(boolean quicksearch) {
        this.quicksearch = quicksearch;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    private int viewcount = 0;

    public int getViewcount(String user) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = Database.getconnect();
            stat = conn.createStatement();
            rs = stat.executeQuery("select viewcount from datingtest01 where userid = '" + user + "'");

            while (rs.next()) {
                viewcount = Integer.parseInt(rs.getString("viewcount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewcount;
    }

    public String updateUserProfile() {

        Database.updateUserProfile(this.loginId);
        setEdit(true);
        return "settings";
    }

    public void setViewcount(int viewcount, String user) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = Database.getconnect();
            stat = conn.createStatement();
            int r = stat.executeUpdate("update datingtest01 set viewcount = " + viewcount + " where userid = '" + user + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.viewcount = viewcount;
    }

    public boolean isIsFriend() {
        
        for(FriendList s : this.loginId.getFriends()){
            if(s.getFriend().getUserid().equals(friend_name)){
                this.setIsFriend(true);
                break;
            }
        }

        return this.isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public boolean friendornot() {
        ArrayList<FriendList> list = this.loginId.getFriends();
        for (FriendList u : list) {
            if (friend_name.equals(u.getFriend().getUserid())) {
                //if user id present 
                setIsFriend(true);
                return true;
            }
        }
        setIsFriend(false);
        return false;
    }

    public ArrayList<FriendList> getFriends() {
        return this.friends;
    }

    public void setFriends(ArrayList<FriendList> friends) {
        this.friends = friends;
    }

    public String getTypedMsg() {
        return typedMsg;
    }

    public void setTypedMsg(String typedMsg) {
        this.typedMsg = typedMsg;
    }

    public ArrayList<msg> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<msg> messages) {
        this.messages = messages;
    }

    public String getFriend_name() {

        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;

    }

    public String ret(String name) {

        setFriend_name(name);
        Database.getFriendViewedMyProfile(friend_name);
        return "friendprofile";
    }

    public String checkUser() {
        String a = Database.checkUser(username, password);
        //obj = db.getuser(username);

        if (a.equals("successful")) {
            this.loginId = new User(username);
            return "home";
        } else {
            return "loginagain";
        }
    }

    public void addFriend() {
        //

    }

    public String createMessage(String fname) {

        setFriend_name(fname);
        Map<String, ArrayList<msg>> maps = Database.allmsgs(this.loginId.getUserid());
        for (Map.Entry f : maps.entrySet()) {
            if (f.getKey().equals(fname)) {
                this.setMessages((ArrayList<msg>) f.getValue());
                break;
            }
        }
        return "messages";

    }

    public void sendMesssage() {
        String content = this.typedMsg;
        String username = this.username;
        String f_nmae = this.friend_name;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
        String dateandtime = sdf.format(cal.getTime());

        Database.sendMessages(username, f_nmae, content, dateandtime);
        createMessage(f_nmae);

    }

    public void sendFriendRequest() {
        String userid = this.loginId.getUserid();
        String friendid = this.friend_name;
        Database.sendFriendRequest(userid, friendid);
        this.loginId.setViewSentFriendRequest(Database.viewSentFriendRequest(userid));
        setIsFriend(true);
    }

    public void cancelFriendRequest() {
        String userid = this.loginId.getUserid();
        String friendid = this.friend_name;
        Database.cancelFriendRequest(userid, friendid);

        
        setIsFriend(false);
    }

    public void enable() {
        this.show = true;

        if (this.SearchName.equals("Discover")) {
            this.friends = loginId.getMatch_serches().getGetDiscover();

        } else if (this.SearchName.equals("Mutual")) {
            this.friends = loginId.getMatch_serches().getGetMyInterestMatchingFriends();

        } else if (this.SearchName.equals("views")) {
            this.friends = loginId.getMatch_serches().getGetFriendViewedMyProfile();

        } else {
            this.friends = loginId.getMatch_serches().getGetMatchByPreferences();

        }
    }

    public void disable() {
        this.show = false;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoginId() {
        return loginId;
    }

    public void setLoginId(User loginId) {
        this.loginId = loginId;
    }

    public User getFriend_id() {
        User u = Database.getUserProfileOfUser(friend_name);
        return u;
    }

    public void setFriend_id(User friend_id) {

        this.friend_id = friend_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = endAge;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getSeekinggender() {
        return seekinggender;
    }

    public void setSeekinggender(String seekinggender) {
        this.seekinggender = seekinggender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSearchName() {
        return SearchName;
    }

    public void setSearchName(String SearchName) {
        this.SearchName = SearchName;
    }

    public String getDiscoverName() {
        return DiscoverName;
    }

    public void setDiscoverName(String DiscoverName) {
        this.DiscoverName = DiscoverName;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

}
