package daoimpl;

import PosSystem.connection.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import PosSystem.model.User;
import dao.UserDao;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public List<User> getUsers() {
        
        String query = "SELECT * FROM user;";
        List<User> users = new ArrayList<>();
        
        try(Connection con = DBConnection.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(query)){
                try(ResultSet rs = ps.executeQuery()){
                    
                    while(rs.next()){
                        
                        User user = new User();
                        
                        user.setId(rs.getInt("user_id"));
                        user.setName(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole(rs.getString("role"));
                        user.setCreateDate(rs.getString("created_at"));
                        users.add(user);
                    }
                }
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean addUser(User u) {
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        return true;
    }

   
    @Override
    public User searchUserByName(String name) {
        String query = "SELECT * FROM user WHERE username = ?;";
        User user = null;
        
        try(Connection con = DBConnection.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(query)){
                    ps.setString(1, name);
                try(ResultSet rs = ps.executeQuery()){
                    
                    if(rs.next()){
                        user = new User();
                        user.setId(rs.getInt("user_id"));
                        user.setName(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole(rs.getString("role"));
                        user.setCreateDate(rs.getString("created_at"));
                    }
                }
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
