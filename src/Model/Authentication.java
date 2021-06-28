package Model;

import Controller.SessionController;
import Db.RailwayDb;

import java.util.ArrayList;

public class Authentication {
    private ArrayList<UserAccount> authenticatedAccounts;
    RailwayDb db = SessionController.getDb();

    public Authentication() {
        authenticatedAccounts = db.getAccounts();
    }

    public boolean validateUserName(String userName){
        for(UserAccount account : authenticatedAccounts){
            if(account.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public boolean validateCredential(String userName, String password){
        for(UserAccount account : authenticatedAccounts){
            if(account.getUserName().equals(userName)){
                if(account.getPassword(userName).equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public UserAccount getUserAccount(String userName, String password){
        for(UserAccount account : authenticatedAccounts){
            if(account.getUserName().equals(userName)){
                if(account.getPassword(userName).equals(password)){
                    return account;
                }
            }
        }
        return null;
    }

    public void register(UserAccount user){
        RailwayDb db = SessionController.getDb();
        db.addAccount(user);
    }

    public ArrayList<UserAccount> getAuthenticatedAccounts() {
        return authenticatedAccounts;
    }
}
