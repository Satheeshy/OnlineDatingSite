/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author yadavas9800
 */
@Named(value = "register")
@RequestScoped
public class register {
  
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


    /**
     * Creates a new instance of register
     */
    public register() {
    }
    
    public String add(){
        User u = new User(ufirstname, ulastname, userid, uemailid, upassword, ugender, uage, 
                ucity, uzipcode, udob, uethnicity, ureligion, ulanguage, useeking, urelationshipstatus, 
                ueducation, uoccupation, uincome, utype, uinterest01, uinterest02, uinterest03, usecurityq01,
                usecurityq02, uanswer01, uanswer02, mage, mlanguage, mincome, mrelationshipstatus, mreligion, methnicity, meducation, moccupation,mcity);
        
        Database.createAccount(u);
        
        return "index";
    }

    public String getMcity() {
        return mcity;
    }

    public void setMcity(String mcity) {
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
    
    
    
}
