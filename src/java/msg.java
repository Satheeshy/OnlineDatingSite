/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yadavas9800
 */
public class msg {
    
     private String receiver;
    private String content;
    private String dateandtime;
   

    public msg(String receiver, String content, String dateandtime) {
        this.receiver = receiver;
        this.content = content;
        this.dateandtime = dateandtime;
        
    }

   

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }

    
}
