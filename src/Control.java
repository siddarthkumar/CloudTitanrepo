/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO
 */
public class Control {
       
   
    public static void splash2()
    {
         Splash2 sp = new Splash2();
        sp.setVisible(true);
        try
        {  
            for(int i =0; i<=100; i++)
            {
                Thread.sleep(50);
                sp.num.setText(Integer.toString(i)+"%");
                sp.load.setValue(i);
                
                if(i==100)
                {
                   sp.dispose();
                  new Login().setVisible(true);               
                }
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    // Second Splash screen code
     public static void splash()
    {
         Splash sp = new Splash();
        sp.setVisible(true);
        try
        {  
            for(int i =0; i<=100; i++)
            {
                Thread.sleep(40);
                sp.num.setText(Integer.toString(i)+"%");
                sp.load.setValue(i);
                
                if(i==100)
                {
                   sp.dispose();
                  new Login().setVisible(true);               
                }
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args) {
       
               //splash2();
               splash();
    }
    
}
