
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
 public void Register(String u,String ps,String n,String ph,String e) throws SQLException
   {
       Connection_app conn1 = new Connection_app() ;
       Connection conn = null;
       conn =conn1.Create_conn() ;
   try {
    String query;
    query = "insert * into dbo.\"renter\"(username,password,name,phonenumber,email,age,gender)values(?,?,?,?,?,?,?,?)";
   
    PreparedStatement pst = conn.prepareStatement(query);
    pst.setString(1, u);
    pst.setString(2, ps);
    pst.setString(3, n);
    pst.setString(4, ph);
    pst.setString(5, e);
    
   
    }
   catch(HeadlessException | SQLException err){
            JOptionPane.showMessageDialog(null, e);
        }
   
   
   }
 public void Add_unit(String rn ,String addr ,String area,String desc,String mate_no,String price ,String rnum) throws SQLException
 {
     Connection  conn = null ;
       Connection_app conn1 = new Connection_app() ;
       conn =conn1.Create_conn() ;
       String query;
    query = "insert * into dbo.\"Apartement\"(username,address,area,description,mates,price,rnum)values(?,?,?,?,?,?,?,?)";
     PreparedStatement pst = conn.prepareStatement(query);
     pst.setString(1, rn);
     pst.setString(2, addr);
     pst.setString(3, area);
     pst.setString(4, desc);
     pst.setString(5, mate_no);
     pst.setString(6, price);
     pst.setString(7, price);
     pst.setString(8, rnum);   
     
    
     
 
 
 }

    
}
  
           
    

