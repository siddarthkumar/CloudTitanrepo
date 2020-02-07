 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siddarth
 */
public class Geek {
   private static Geek g;
    private String username=null;
    private String  email=null;
    private  String password=null;
    private String  aiousername= null;
    private String aiokey=null;
    private Geek(String username,String email,String password,String aiousername,String aiokey)
    {
    this.username=username;
    this.email=email;
    this.password=password;
    this.aiousername=aiousername;
    this.aiokey=aiokey; 
    }
    static Geek getgeek(String username,String email,String password,String aiousername,String aiokey)
    {
        g=new Geek(username,email,password,aiousername,aiokey);
        return g;
    }

    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String getAiousername() {
        return aiousername;
    }

    public void setAiousername(String aiousername) {
        this.aiousername = aiousername;
    }

    public String getAiokey() {
        return aiokey;
    }

  
    public void setAiokey(String aiokey) {
        this.aiokey = aiokey;
    }
    
    
}
