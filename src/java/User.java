
import java.util.ArrayList;
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
public class User {
    
    private String ufirstname	;
private String 		ulastname	;
private String 		userid	;
private String 		uemailid	;
private String 		upassword	;
private String 		ugender	;
private int 		uage	;
private String 		ucity	;
private String 		uzipcode	;
private String 		udob	;
private String 		uethnicity	;
private String 		ureligion	;
private String 		ulanguage	;
private String 		useeking	;
private String 		urelationshipstatus	;
private String 		ueducation	;
private String 		uoccupation	;
private double 		uincome	;
private String 		utype	;
private String 		uinterest01	;
private String 		uinterest02	;
private String 		uinterest03	;
private String 		usecurityq01	;
private String 		usecurityq02	;
private String 		uanswer01	;
private String 		uanswer02	;
private int 		mage	;
private String 		mlanguage	;
private double 		mincome	;
private String 		mrelationshipstatus	;
private String 		mreligion	;
private String 		methnicity	;
private String 		meducation	;
private String 		moccupation	;
private String mcity;
private ArrayList<FriendList> friends;
private ArrayList<FriendList> viewSentFriendRequest;
private ArrayList<FriendList> viewreceivedFriendRequest;
private Match match_serches;

//this constructor is for managed bean
    public User(String userid) {
        
        User  u =  Database.UserData(userid);
        this.ufirstname = u.getUfirstname();
        this.ulastname = u.getUlastname();
        this.userid = u.getUserid();
        this.uemailid = u.getUemailid();
        this.upassword = u.getUpassword();
        this.ugender = u.getUgender();
        this.uage = u.getUage();
        this.ucity = u.getUcity();
        this.uzipcode = u.getUzipcode();
        this.udob = u.getUdob();
        this.uethnicity = u.getUethnicity();
        this.ureligion = u.getUreligion();
        this.ulanguage = u.getUlanguage();
        this.useeking = u.getUseeking();
        this.urelationshipstatus = u.getUrelationshipstatus();
        this.ueducation = u.getUeducation();
        this.uoccupation = u.getUoccupation();
        this.uincome = u.getUincome();
        this.utype = u.getUtype();
        this.uinterest01 = u.getUinterest01();
        this.uinterest02 = u.getUinterest02();
        this.uinterest03 = u.getUinterest03();
        this.usecurityq01 = u.getUsecurityq01();
        this.usecurityq02 = u.getUsecurityq02();
        this.uanswer01 = u.getUanswer01();
        this.uanswer02 = u.getUanswer02();
        this.mage = u.getMage();
        this.mlanguage = u.getMlanguage();
        this.mincome = u.getMincome();
        this.mrelationshipstatus = u.getMrelationshipstatus();
        this.mreligion = u.getMreligion();
        this.methnicity = u.getMethnicity();
        this.meducation = u.getMeducation();
        this.moccupation = u.getMoccupation();
        this.mcity = u.getMcity();
        this.setFriends(u.getFriends());
        this.setMatch_serches(u.getMatch_serches());
        this.setViewSentFriendRequest(u.getViewSentFriendRequest());
        this.setViewreceivedFriendRequest(u.getViewreceivedFriendRequest());
        
    }

   //this constructor is for registration
    public User(String ufirstname, String ulastname, String userid, String uemailid, String upassword, String ugender, int uage, String ucity, String uzipcode, String udob, String uethnicity, String ureligion, String ulanguage, String useeking, String urelationshipstatus, String ueducation, String uoccupation, double uincome, String utype, String uinterest01, String uinterest02, String uinterest03, String usecurityq01, 
            String usecurityq02, String uanswer01, String uanswer02, int mage, String mlanguage, double mincome, String mrelationshipstatus, String mreligion, 
            String methnicity, String meducation, String moccupation,String mcity) {
      
       
        this.ufirstname = ufirstname;
        this.ulastname = ulastname;
        this.userid = userid;
        this.uemailid = uemailid;
        this.upassword = upassword;
        this.ugender = ugender;
        this.uage = uage;
        this.ucity = ucity;
        this.uzipcode = uzipcode;
        this.udob = udob;
        this.uethnicity = uethnicity;
        this.ureligion = ureligion;
        this.ulanguage = ulanguage;
        this.useeking = useeking;
        this.urelationshipstatus = urelationshipstatus;
        this.ueducation = ueducation;
        this.uoccupation = uoccupation;
        this.uincome = uincome;
        this.utype = utype;
        this.uinterest01 = uinterest01;
        this.uinterest02 = uinterest02;
        this.uinterest03 = uinterest03;
        this.usecurityq01 = usecurityq01;
        this.usecurityq02 = usecurityq02;
        this.uanswer01 = uanswer01;
        this.uanswer02 = uanswer02;
        this.mage = mage;
        this.mlanguage = mlanguage;
        this.mincome = mincome;
        this.mrelationshipstatus = mrelationshipstatus;
        this.mreligion = mreligion;
        this.methnicity = methnicity;
        this.meducation = meducation;
        this.moccupation = moccupation;
        this.mcity = mcity;
    }

   
    public String getUfirstname() {
        return ufirstname;
    }

    public void setUfirstname(String ufirstname) {
        this.ufirstname = ufirstname;
    }

    public String getUlastname() {
        return ulastname;
    }

    public void setUlastname(String ulastname) {
        this.ulastname = ulastname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUemailid() {
        return uemailid;
    }

    public void setUemailid(String uemailid) {
        this.uemailid = uemailid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public String getUzipcode() {
        return uzipcode;
    }

    public void setUzipcode(String uzipcode) {
        this.uzipcode = uzipcode;
    }

    public String getUdob() {
        return udob;
    }

    public void setUdob(String udob) {
        this.udob = udob;
    }

    public String getUethnicity() {
        return uethnicity;
    }

    public void setUethnicity(String uethnicity) {
        this.uethnicity = uethnicity;
    }

    public String getUreligion() {
        return ureligion;
    }

    public void setUreligion(String ureligion) {
        this.ureligion = ureligion;
    }

    public String getUlanguage() {
        return ulanguage;
    }

    public void setUlanguage(String ulanguage) {
        this.ulanguage = ulanguage;
    }

    public String getUseeking() {
        return useeking;
    }

    public void setUseeking(String useeking) {
        this.useeking = useeking;
    }

    public String getUrelationshipstatus() {
        return urelationshipstatus;
    }

    public void setUrelationshipstatus(String urelationshipstatus) {
        this.urelationshipstatus = urelationshipstatus;
    }

    public String getUeducation() {
        return ueducation;
    }

    public void setUeducation(String ueducation) {
        this.ueducation = ueducation;
    }

    public String getUoccupation() {
        return uoccupation;
    }

    public void setUoccupation(String uoccupation) {
        this.uoccupation = uoccupation;
    }

    public double getUincome() {
        return uincome;
    }

    public void setUincome(double uincome) {
        this.uincome = uincome;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getUinterest01() {
        return uinterest01;
    }

    public void setUinterest01(String uinterest01) {
        this.uinterest01 = uinterest01;
    }

    public String getUinterest02() {
        return uinterest02;
    }

    public void setUinterest02(String uinterest02) {
        this.uinterest02 = uinterest02;
    }

    public String getUinterest03() {
        return uinterest03;
    }

    public void setUinterest03(String uinterest03) {
        this.uinterest03 = uinterest03;
    }

    public String getUsecurityq01() {
        return usecurityq01;
    }

    public void setUsecurityq01(String usecurityq01) {
        this.usecurityq01 = usecurityq01;
    }

    public String getUsecurityq02() {
        return usecurityq02;
    }

    public void setUsecurityq02(String usecurityq02) {
        this.usecurityq02 = usecurityq02;
    }

    public String getUanswer01() {
        return uanswer01;
    }

    public void setUanswer01(String uanswer01) {
        this.uanswer01 = uanswer01;
    }

    public String getUanswer02() {
        return uanswer02;
    }

    public void setUanswer02(String uanswer02) {
        this.uanswer02 = uanswer02;
    }

    public int getMage() {
        return mage;
    }

    public void setMage(int mage) {
        this.mage = mage;
    }

    public String getMlanguage() {
        return mlanguage;
    }

    public void setMlanguage(String mlanguage) {
        this.mlanguage = mlanguage;
    }

    public double getMincome() {
        return mincome;
    }

    public void setMincome(double mincome) {
        this.mincome = mincome;
    }

    public String getMrelationshipstatus() {
        return mrelationshipstatus;
    }

    public void setMrelationshipstatus(String mrelationshipstatus) {
        this.mrelationshipstatus = mrelationshipstatus;
    }

    public String getMreligion() {
        return mreligion;
    }

    public void setMreligion(String mreligion) {
        this.mreligion = mreligion;
    }

    public String getMethnicity() {
        return methnicity;
    }

    public void setMethnicity(String methnicity) {
        this.methnicity = methnicity;
    }

    public String getMeducation() {
        return meducation;
    }

    public void setMeducation(String meducation) {
        this.meducation = meducation;
    }

    public String getMoccupation() {
        return moccupation;
    }

    public void setMoccupation(String moccupation) {
        this.moccupation = moccupation;
    }

    public String getMcity() {
        return mcity;
    }

    public void setMcity(String mcity) {
        this.mcity = mcity;
    }

    public ArrayList<FriendList> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<FriendList> friends) {
        this.friends = friends;
    }

  
   
  

    public Match getMatch_serches() {
        return match_serches;
    }

    public void setMatch_serches(Match match_serches) {
        this.match_serches = match_serches;
    }

    public ArrayList<FriendList> getViewSentFriendRequest() {
        return viewSentFriendRequest;
    }

    public void setViewSentFriendRequest(ArrayList<FriendList> viewSentFriendRequest) {
        this.viewSentFriendRequest = viewSentFriendRequest;
    }

    public ArrayList<FriendList> getViewreceivedFriendRequest() {
        return viewreceivedFriendRequest;
    }

    public void setViewreceivedFriendRequest(ArrayList<FriendList> viewreceivedFriendRequest) {
        this.viewreceivedFriendRequest = viewreceivedFriendRequest;
    }

  
}