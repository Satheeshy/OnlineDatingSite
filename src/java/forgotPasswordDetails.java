/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author VeeraPrakash
 */
@Named(value = "forgotPasswordDetails")
@SessionScoped
public class forgotPasswordDetails implements Serializable {

    /**
     * Creates a new instance of forgotPasswordDetails
     */
    public forgotPasswordDetails() 
    {
        
    }
     private User u;
     
    private String username;
    private String uanswer01;
    private String uanswer02;
    private boolean show = true;
    private boolean showbelow = false;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.showbelow= true;
        this.show = show;
    }

    public boolean isShowbelow() {
        return showbelow;
    }

    
    
    
    public String  getData(String username)
    {
      User u = null;  
        u = Database.forgotUserCheck(username);
        if(u== null)
        {
            System.out.println("Please enter a valid User ID");  
            return "forgotPassword";
        }
        else
        {
            setU(u);
            return "showQuestions";
        }
        
        
        
         
    }
    public String validate(String username)
    {
        
        if(u.getUanswer01().equalsIgnoreCase(uanswer01) && u.getUanswer02().equalsIgnoreCase(uanswer02))
        {
            return "newpassword";
            
        }else 
        {
           return "forgotpasswordagain";
            
        }
             
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
}
