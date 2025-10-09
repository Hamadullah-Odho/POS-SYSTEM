package dao;

import PosSystem.model.User;
import java.util.List;

public interface UserDao {
    
    public List<User> getUsers();
    public boolean addUser(User u);
    public boolean updateUser(User u);
    public User searchUserByName(String name);
    
}
