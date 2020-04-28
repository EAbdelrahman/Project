
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kc
 */
public class renter {
 public void Login(String x,String y) throws SQLException{
       Connection  conn = null ;
       Connection_app conn1 = new Connection_app() ;
       conn =conn1.Create_conn() ;
   try {
    String sql;
    sql = "select * from dbo.\"renter\" where username = ? and password = ?"; // depends on the name for your tables and columns 
   
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, x);
    pst.setString(2, y);
   ResultSet rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and Password Matched");
                
             
            }
            else{
                JOptionPane.showMessageDialog(null, "Username and password not Correct");
                x= " ";
                y= " ";
            }
            conn.close();

   }
   catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
   finally {
   x= "     ";
   y= "     ";
   }


}

    
}
  
           
    

