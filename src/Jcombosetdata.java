
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siddarth
 */
public class Jcombosetdata {
    
 static BufferedReader reader;
 static String line;
    private static HttpURLConnection connection;
    public static  String getData(String s)
    {
        StringBuffer response= new StringBuffer();
        String s1,s2 = null;
   try {
        String head="https://io.adafruit.com/api/v2/siderminator/feeds/";
        String foot="/data?limit=1";
        //String device = JOptionPane.showInputDialog("Please Enter the device");
        String devurl=head.concat(s).concat(foot);
        System.out.println(devurl);   
        URL url = new URL(devurl);
        connection=(HttpURLConnection)url.openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
        connection.connect();
        int responsecode = connection.getResponseCode();
                  if(responsecode>299){reader= new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                  while((line=reader.readLine())!=null){response.append(line);}
                  reader.close();
                  }else{reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
                  while((line=reader.readLine())!=null){response.append(line);}
                  reader.close();
                  s1=removeCharAt(response.toString(),0);
                  s2=removeCharAt(s1,s1.length()-1);
                  System.out.println(s2);
                  }
                  //System.out.println(response.toString());
                 
            }catch(Exception e){e.printStackTrace();
            }    
   finally{connection.disconnect();}
 return s2;
 }
    public static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}
    
    public static String senddata(String s,String jabong) throws MalformedURLException, IOException
    {
    String response=null;
          try {
        String head="https://io.adafruit.com/api/v2/siderminator/feeds/";
        String foot="/data";
       // String device = JOptionPane.showInputDialog("Please Enter the device");
        String devurl=head.concat(s).concat(foot);
        System.out.println(devurl);
        URL url = new URL(devurl);
        JSONObject jo = new JSONObject();
    // String value =JOptionPane.showInputDialog("Please Enter the value");
        jo.put("value",jabong);
        JSONObject jon = new JSONObject();
        jon.put("datum",jo);
        
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("X-AIO-Key", "c708e272790e46e4bf242417dda4d834");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.connect();
        System.out.println(jon.toString());
       OutputStream os = con.getOutputStream();
     
        byte[] b = jon.toString().getBytes("utf-8");
        os.write(b);
        JOptionPane.showMessageDialog(null,"successfullysent");
        
        
         response =con.getResponseMessage();
        System.out.println(response);
        //String resp = "ok";
      //  if(response.equalsIgnoreCase(resp)==true){voice.speak("sent successfully your fan is on");}
        //else{voice.speak("failed to send");}
        con.disconnect();
     System.out.println(jon.toString());
        
    } catch (JSONException ex) {
      JOptionPane.showMessageDialog(null,ex);
    }
        
        return response;
    }
    
}
