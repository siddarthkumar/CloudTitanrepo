/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siddarth
 */
import static java.lang.Class.forName;
import java.sql.*;
public class Connectivity {
 private static Connection con = null;   
 private  String url="jdbc:oracle:thin:@localhost:1521:xe";
 private static PreparedStatement ps = null;
 private static String sql;
    private Connectivity() throws SQLException, ClassNotFoundException
    {      
        Class.forName("oracle.jdbc.OracleDriver");
    this.con= DriverManager.getConnection(url,"system","12345");
    
    }
    public boolean deleteData()
    {
        return true;
    }
   public boolean insertData(Geek g) throws SQLException
   {
       this.ps=con.prepareStatement(sql);
     ps.setString(1,g.getUsername());
     ps.setString(2,g.getEmail());
     ps.setString(3,g.getAiousername());
     ps.setString(4,g.getAiokey());
     ps.setString(5,g.getPassword());
     int a = ps.executeUpdate();
     if(a!=0){return true;}
     else{ return false;}
   }
   public boolean updateData(Geek g)
   {
     return true;
   }
   static ResultSet result(String username) throws SQLException
   {   ps=con.prepareStatement(sql);
   ps.setString(1,username);
    ResultSet rs = ps.executeQuery();
       return rs;
   }
   public void setQuery(String s)
   {
   this.sql=s;
   }
   public static Connectivity getCon() throws SQLException, ClassNotFoundException
   {
      Connectivity con = new Connectivity();
    return con;
            
   
   }
      
}
