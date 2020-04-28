import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class User  {

    public Connection conn;
   
 /*  public Connection Create_conn(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection_app.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url="jdbc:sqlserver://localhost:1433;databaseName=User;user=abdelrahman;password=01115404262";
        try {
             con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Connection_app.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        return con  ;
      
    }

  public  Connection conn= Create_conn() ;
   
    
   */
   public void Login(String x,String y) throws SQLException{
       
       Connection_app conn1 = new Connection_app() ;
       conn =conn1.Create_conn() ;
   try {
    String sql;
    sql = "select * from user where username = ? and password = ?";
   
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
