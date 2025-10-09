package controller;

import PosSystem.model.User;
import dao.UserDao;
import daoimpl.UserDaoImpl;
import session.CurrentSession;

public class LoginController {
    
    private UserDao userdao;
    
    public LoginController(){
        userdao = new UserDaoImpl();
    }
    
    public boolean login(String username , String password){
            
        User user = userdao.searchUserByName(username);
        
        if(user != null && user.getPassword().equals(password)){
            CurrentSession.setCurrentUser(user);
            return true;
        }
        return false;
    }
    
}
