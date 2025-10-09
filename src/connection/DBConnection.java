package PosSystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    
    private DBConnection(){}
    
    public static Connection getConnection(){
        
        Connection connection = null;
        String user = "root";
        String pass = "0324";
        String url = "jdbc:mysql://localhost:3306/pos_system";
        
        try{connection = DriverManager.getConnection(url, user, pass);}
        catch(SQLException e){e.printStackTrace();}
        
        return connection;
    }
    
}
