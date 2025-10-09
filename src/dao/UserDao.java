package PosSystem.dao;

import PosSystem.model.User;
import java.util.List;

public interface UserDao {
    
    public List<User> getUsers();
    public boolean addUser(User u);
    public boolean updateUser(User u);
    public boolean userLogin(String username , String pass);
    
}
