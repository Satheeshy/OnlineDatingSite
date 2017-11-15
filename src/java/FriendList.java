/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yadavas9800
 */
public class FriendList {

    private User friend;

    public FriendList() {
    }
    
    

    public FriendList(String ufirstname, String ulastname, String userid, String uemailid, String upassword, String ugender, int uage, String ucity, String uzipcode, String udob, String uethnicity, String ureligion, String ulanguage, String useeking, String urelationshipstatus, String ueducation, String uoccupation, double uincome, String utype, String uinterest01, String uinterest02, String uinterest03, String usecurityq01,
            String usecurityq02, String uanswer01, String uanswer02, int mage, String mlanguage, double mincome, String mrelationshipstatus, String mreligion,
            String methnicity, String meducation, String moccupation, String mcity) {
      
        this.friend = new User(ufirstname, ulastname, userid, uemailid, upassword, ugender, uage, ucity, uzipcode, 
                udob, uethnicity, ureligion, ulanguage, useeking, urelationshipstatus, ueducation, uoccupation, uincome,
                utype, uinterest01, uinterest02, uinterest03, usecurityq01, usecurityq02, uanswer01, uanswer02, mage, mlanguage, 
                mincome, mrelationshipstatus, mreligion, methnicity, meducation, moccupation, mcity);
        
    }

    public User getFriend() {
        return friend;
    }
    
    public void setFriend(User friend) {
        this.friend = friend;
    }

}
