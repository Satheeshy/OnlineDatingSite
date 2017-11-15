
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yadavas9800
 */
public class Database {

      public static User forgotUserCheck(String username)
    {
        User u = null;
        Connection conn = null;
        try
        {
            conn = Database.getconnect();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select userid from datingtest01 where userid = '"+username+"'");
            while(rs.next())
            {
               u = getUserProfileOfUser(rs.getString("userid"));
                }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
    
    public static Connection getconnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mis-sql.uhcl.edu/kurapativ5434", "kurapativ5434", "1447544");

        } catch (Exception e) {
            e.printStackTrace();;
        }
        return con;
    }

    public static User UserData(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User udata = null;
        try {
            conn = getconnect();
            //first assign user profile
            udata = getUserProfileOfUser(username);
            //now assign friendlist
            udata.setFriends(getFriendList(username));
            //now get msgs
            //now get search except quick search
            Match obj = new Match(getMyInterestMatchingFriends(username), getMatchByPreferences(username), getFriendViewedMyProfile(username), getDiscover(username));
            udata.setMatch_serches(obj);
            //now check to whom he sent request and from whom he received request

            udata.setViewSentFriendRequest(viewSentFriendRequest(username));
            udata.setViewreceivedFriendRequest(viewReceivedFriendRequest(username));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return udata;

    }

    public static User getUserProfileOfUser(String username) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        User udata = null;
        try {
            conn = getconnect();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from datingtest01 where userid = '" + username + "'");

            while (rs.next()) {
                udata = new User(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12),
                        rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getString(17), rs.getDouble(18),
                        rs.getString(19), rs.getString(20), rs.getString(21),
                        rs.getString(22), rs.getString(23), rs.getString(24),
                        rs.getString(25), rs.getString(26), rs.getInt(27),
                        rs.getString(28), rs.getDouble(29), rs.getString(30),
                        rs.getString(31), rs.getString(32), rs.getString(33),
                        rs.getString(34), rs.getString(35));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return udata;
    }

    public static ArrayList<FriendList> getFriendList(String usernmae) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<FriendList> friends = new ArrayList<>();
        try {
            conn = getconnect();
            ps = conn.prepareStatement("SELECT * FROM matched where userid = ?");
            ps.setString(1, usernmae);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = getUserProfileOfUser(rs.getString(2));
                FriendList f = new FriendList();
                f.setFriend(u);
                friends.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return friends;

    }

    public static Map<String, ArrayList<msg>> allmsgs(String username) {

        Map<String, ArrayList<msg>> allconversations = new HashMap<String, ArrayList<msg>>();

        ArrayList<String> matched = new ArrayList<String>();
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/kurapativ5434";

        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //connect tothe databse
            connection = DriverManager.getConnection(DATABASE_URL,
                    "kurapativ5434", "1447544");
            //create a statement
            stat = connection.createStatement();
            rs = stat.executeQuery("select muserid from matched where userid='" + username + "'");
            while (rs.next()) {
                matched.add(rs.getString("muserid"));
            }
            rs = null;

            for (String m : matched) {

                rs = stat.executeQuery("Select * from chatbox where (senderid = '" + username + "'" + "and receiverid='" + m + "') or (senderid = '" + m + "'" + "and receiverid='" + username + "')");
                ArrayList<msg> msg = new ArrayList<msg>();
                while (rs.next()) {

                    if (username.equals(rs.getString("senderid")) || m.equals(rs.getString("receiverid"))) {
                        msg.add(new msg(username, rs.getString("content"), rs.getString("dateandtime")));

                    } else if (username.equals(rs.getString("receiverid")) || m.equals(rs.getString("senderid"))) {
                        msg.add(new msg(m, rs.getString("content"), rs.getString("dateandtime")));

                    }
                }
                allconversations.put(m, msg);
            }
        } catch (SQLException e) {
            System.out.println("updating allmsgs failed");
            e.printStackTrace();
        } finally {
            //close the database
            try {
                rs.close();
                stat.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return allconversations;
    }

    public static void createAccount(User u) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getconnect();
            ps = con.prepareStatement("insert into datingtest01 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getUfirstname());
            ps.setString(2, u.getUlastname());
            ps.setString(3, u.getUserid());
            ps.setString(4, u.getUemailid());
            ps.setString(5, u.getUpassword());
            ps.setString(6, u.getUgender());
            ps.setInt(7, u.getUage());
            ps.setString(8, u.getUcity());
            ps.setString(9, u.getUzipcode());
            ps.setString(10, u.getUdob());
            ps.setString(11, u.getUethnicity());
            ps.setString(12, u.getUreligion());
            ps.setString(13, u.getUlanguage());
            ps.setString(14, u.getUseeking());
            ps.setString(15, u.getUrelationshipstatus());
            ps.setString(16, u.getUeducation());
            ps.setString(17, u.getUoccupation());
            ps.setDouble(18, u.getUincome());
            ps.setString(19, u.getUtype());
            ps.setString(20, u.getUinterest01());
            ps.setString(21, u.getUinterest02());
            ps.setString(22, u.getUinterest03());
            ps.setString(23, u.getUsecurityq01());
            ps.setString(24, u.getUsecurityq02());
            ps.setString(25, u.getUanswer01());
            ps.setString(26, u.getUanswer02());
            ps.setInt(27, u.getMage());
            ps.setString(28, u.getMlanguage());
            ps.setDouble(29, u.getMincome());
            ps.setString(30, u.getMrelationshipstatus());
            ps.setString(31, u.getMreligion());
            ps.setString(32, u.getMethnicity());
            ps.setString(33, u.getMeducation());
            ps.setString(34, u.getMoccupation());
            ps.setString(35, u.getMcity());
            ps.setInt(36, 0);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMessages(String user, String friendid, String msg, String date) {
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            conn = Database.getconnect();
            ps = conn.createStatement();
            ps.executeUpdate("Insert into chatbox values('" + user + "','" + friendid + "','" + msg + "','" + date + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String checkUser(String username, String password) {
        Connection con = null;
        try {
            con = Database.getconnect();
            PreparedStatement ps = con.prepareStatement("select * from datingtest01 where userid=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).equals(username)) {
                    if (rs.getString(5).equals(password)) {
                        return "successful";
                    }
                    return "not successful";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "not successful";
    }

    public static ArrayList<FriendList> getMatchByPreferences(String username) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<FriendList> friends = new ArrayList<>();

        try {
            con = Database.getconnect();
            stat = con.createStatement();
            String mlanguage = "";
            String methnicity = "";
            int mage = 0;
            double mincome = 0;
            String mrelationshipstatus = "";
            String moccupation = "";
            String meducation = "";
            String mcity = "";
            rs = stat.executeQuery("select * from datingtest01 where userid='" + username + "'");

            while (rs.next()) {
                mlanguage = rs.getString("mlanguage");
                methnicity = rs.getString("methnicity");
                mage = rs.getInt("mage");
                mincome = rs.getDouble("mincome");
                mrelationshipstatus = rs.getString("mrelationshipstatus");
                moccupation = rs.getString("moccupation");
                meducation = rs.getString("meducation");
                mcity = rs.getString("mcity");

            }
            rs = null;

            //get data about who are already matched, friends
            rs = stat.executeQuery("select muserid from matched where userid='+" + username + "'");
            ArrayList<String> matched = new ArrayList<String>();
            while (rs.next()) {
                matched.add(rs.getString("muserid"));
            }
            rs = null;
            rs = stat.executeQuery("select userid from datingtest01 where mlanguage= '" + mlanguage + "' or methnicity= '" + methnicity + "' or "
                    + "mage=" + mage + " or mincome=" + mincome + " or mrelationshipstatus= '" + mrelationshipstatus + "' or moccupation= '" + moccupation + "' "
                    + "or meducation= '" + meducation + "' or mcity= '" + mcity + "'");
            while (rs.next()) {
                if (!matched.contains(rs.getString("userid")) && !rs.getString("userid").equals(username)) {

                    FriendList f = new FriendList();
                    f.setFriend(getUserProfileOfUser(rs.getString("userid")));
                    friends.add(f);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;

    }

    public static void rejectFriendRequest(String user_id, String friend_id) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = Database.getconnect();

            stat = conn.createStatement();

            int r = stat.executeUpdate("update relationstatus set status = 'rejected' where receiverid = '" + user_id + "' and senderid = '" + friend_id + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUserProfile(User u) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = Database.getconnect();
            stat = conn.createStatement();
            int r = stat.executeUpdate("update datingtest01 set ufirstname = '" + u.getUfirstname() + "', ulastname = '" + u.getUlastname() + "' ,ugender = '" + u.getUgender() + "'"
                    + " ,uethnicity = '" + u.getUethnicity() + "' ,ureligion = '" + u.getMreligion() + "', urelationshipstatus = '" + u.getMrelationshipstatus() + "', ueducation = '" + u.getUeducation()
                    + "' ,uoccupation = '" + u.getUoccupation() + "' ,uincome = " + u.getUincome() + " ,uinterest01 = '" + u.getUinterest01() + "' ,Uinterest02 = '" + u.getUinterest02() + "' ,mage = "
                    + u.getMage() + ", ulanguage = '" + u.getUlanguage() + "' ,mrelationshipstatus = '" + u.getMrelationshipstatus() + "' , mreligion ='" + u.getMreligion() + "', meducation ='" + u.getMeducation()
                    + "', moccupation = '" + u.getMoccupation() + "',usecurityq01 = '" + u.getUsecurityq01() + "', usecurityq02 = '" + u.getUsecurityq02() + "', useeking = '" + u.getUseeking()
                    + "' where userid = '" + u.getUserid() + "'");

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static ArrayList<FriendList> getMyInterestMatchingFriends(String username) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<FriendList> friends = new ArrayList<>();

        try {
            con = Database.getconnect();
            stat = con.createStatement();
            String mlanguage = "";
            String methnicity = "";
            int mage = 0;
            double mincome = 0;
            String mrelationshipstatus = "";
            String moccupation = "";
            String meducation = "";
            String mcity = "";
            rs = stat.executeQuery("select * from datingtest01 where userid='" + username + "'");

            while (rs.next()) {
                mlanguage = rs.getString("ulanguage");
                methnicity = rs.getString("uethnicity");
                mage = rs.getInt("uage");
                mincome = rs.getDouble("uincome");
                mrelationshipstatus = rs.getString("urelationshipstatus");
                moccupation = rs.getString("uoccupation");
                meducation = rs.getString("ueducation");
                mcity = rs.getString("ucity");
            }
            rs = null;

            //get data about who are already matched, friends
            rs = stat.executeQuery("select muserid from matched where userid='+" + username + "'");
            ArrayList<String> matched = new ArrayList<String>();
            while (rs.next()) {
                matched.add(rs.getString("muserid"));
            }
            rs = null;
            rs = stat.executeQuery("select userid from datingtest01 where mlanguage='" + mlanguage + "' and methniciyt='" + methnicity + "' and "
                    + "mage=" + mage + " and mincome=" + mincome + " and mrelationshipstatus='" + mrelationshipstatus + "' and moccupation='" + moccupation + "' "
                    + "and meducation='" + meducation + "' and mcity=" + mcity + "'");
            while (rs.next()) {
                if (!matched.contains(rs.getString("userid"))) {
                    FriendList f = new FriendList();
                    f.setFriend(getUserProfileOfUser(rs.getString("userid")));
                    friends.add(f);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;
    }

    public static ArrayList<FriendList> getDiscover(String username) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<FriendList> friends = new ArrayList<>();

        try {
            con = Database.getconnect();
            stat = con.createStatement();
            String mlanguage = "";
            String methnicity = "";
            int mage = 0;
            double mincome = 0;
            String mrelationshipstatus = "";
            String moccupation = "";
            String meducation = "";
            String mcity = "";
            rs = stat.executeQuery("select * from datingtest01 where userid='" + username + "'");

            while (rs.next()) {
                mlanguage = rs.getString("ulanguage");
                methnicity = rs.getString("uethnicity");
                mage = rs.getInt("uage");
                mincome = rs.getDouble("uincome");
                mrelationshipstatus = rs.getString("urelationshipstatus");
                moccupation = rs.getString("uoccupation");
                meducation = rs.getString("ueducation");
                mcity = rs.getString("ucity");
            }
            rs = null;

            //get data about who are already matched, friends
            rs = stat.executeQuery("select muserid from matched where userid='+" + username + "'");
            ArrayList<String> matched = new ArrayList<String>();
            while (rs.next()) {
                matched.add(rs.getString("muserid"));
            }
            rs = null;
            rs = stat.executeQuery("select userid from datingtest01 where mlanguage='" + mlanguage + "' or methniciyt='" + methnicity + "' or "
                    + "mage=" + mage + " or mincome=" + mincome + " or mrelationshipstatus='" + mrelationshipstatus + "' or moccupation='" + moccupation + "' "
                    + "or meducation='" + meducation + "' or mcity=" + mcity + "'");
            while (rs.next()) {
                if (!matched.contains(rs.getString("userid"))) {
                    FriendList f = new FriendList();
                    f.setFriend(getUserProfileOfUser(rs.getString("userid")));
                    friends.add(f);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;
    }

    public static ArrayList<FriendList> getFriendViewedMyProfile(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<FriendList> friends = new ArrayList<>();
        try {
            conn = getconnect();

            ps = conn.prepareStatement("select * from viewed where userid = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                FriendList f = new FriendList();
                f.setFriend(getUserProfileOfUser(rs.getString(2)));
                friends.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return friends;

    }

    public static ArrayList<FriendList> getByLocationAge(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<FriendList> friends = new ArrayList<>();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        return friends;

    }

    public static void sendFriendRequest(String user_id, String friend_id) {
        Connection con = null;
        try {
            con = Database.getconnect();
            //before adding check both uses

            PreparedStatement ps = con.prepareStatement("insert into relationstatus values(?,?,?)");
            ps.setString(1, user_id);
            ps.setString(2, friend_id);
            ps.setString(3, "pending");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FriendList> viewSentFriendRequest(String user_id) {
        Connection con = null;
        ResultSet rs = null;
        ArrayList<FriendList> viewSentFriendRequest = new ArrayList<>();
        try {
            con = Database.getconnect();
            //before adding check both uses

            PreparedStatement ps = con.prepareStatement("select * from relationstatus where senderid=? and status=? ");
            ps.setString(1, user_id);
            ps.setString(2, "pending");
            rs = ps.executeQuery();
            while (rs.next()) {
                FriendList f = new FriendList();
                f.setFriend(getUserProfileOfUser(rs.getString(2)));
                viewSentFriendRequest.add(f);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewSentFriendRequest;
    }

    public static void cancelFriendRequest(String user_id, String friend_id) {
        Connection con = null;
        try {
            con = Database.getconnect();
            //before adding check both uses

            PreparedStatement ps = con.prepareStatement("update relationstatus set status = ? where senderid=? and receiverid=?");
            ps.setString(1, "cancel");
            ps.setString(2, user_id);
            ps.setString(3, friend_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FriendList> viewReceivedFriendRequest(String user_id) {
        Connection con = null;
        ResultSet rs = null;
        ArrayList<FriendList> viewReceivedFriendRequest = new ArrayList<>();
        try {
            con = Database.getconnect();
            //before adding check both uses

            PreparedStatement ps = con.prepareStatement("select * from relationstatus where receiverid=? and status=?");
            ps.setString(1, user_id);
            ps.setString(2, "pending");
            rs = ps.executeQuery();
            while (rs.next()) {
                FriendList f = new FriendList();
                f.setFriend(getUserProfileOfUser(rs.getString(1)));
                viewReceivedFriendRequest.add(f);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewReceivedFriendRequest;
    }

    public static void acceptFriendReqest(String user_id, String friend_id) {
        Connection con = null;
        try {
            con = Database.getconnect();
            //before adding check both uses

            PreparedStatement ps = con.prepareStatement("insert into matched values(?,?)");
            ps.setString(1, user_id);
            ps.setString(2, friend_id);
            ps.executeUpdate();
            //insert another recoerd
            ps = con.prepareStatement("insert into matched values(?,?)");
            ps.setString(1, friend_id);
            ps.setString(2, user_id);
            ps.executeUpdate();
            ps = con.prepareStatement("update relationstatus set status = ? where senderid =? and receiverid = ? ");
            ps.setString(1, "accepted");
            ps.setString(2, friend_id);
            ps.setString(3, user_id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FriendList> getQuickSearch(String username, String gend, int sAge, int eAge, String sCity) {

        ArrayList<FriendList> list = new ArrayList<FriendList>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            con = Database.getconnect();
            ps = con.prepareStatement("select * from datingtest01 d where (d.uage between ? and ? or d.ucity = ? or d.ugender =?) and d.userid != ? and d.userid not in (select m.muserid from matched m where userid = ?)");
            ps.setInt(1, sAge);
            ps.setInt(2, eAge);
            ps.setString(3, sCity);
            ps.setString(4, gend);
            ps.setString(5, username);
            ps.setString(6, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = getUserProfileOfUser(rs.getString(2));
                FriendList f = new FriendList();
                if(u!=null){
                    f.setFriend(u);
                     list.add(f);
                }
              

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
