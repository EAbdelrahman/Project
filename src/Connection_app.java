
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException ;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kc
 */
public class Connection_app {

    /**
     *
     * @return
     */
    public Connection Create_conn(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection_app.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url;
        url = "jdbc:sqlserver://localhost:1433;databaseName=User;user=abdelrahman;password=01115404262";
        try {
             con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Connection_app.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        return con  ;
      
    }

 
    
}
