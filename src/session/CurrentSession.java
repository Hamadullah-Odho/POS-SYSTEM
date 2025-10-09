package session;

import PosSystem.model.User;

public class CurrentSession {
    
    private static User currentUser;
    
    
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public static User getCurrentUser(){
        return currentUser;
    }
    
}
