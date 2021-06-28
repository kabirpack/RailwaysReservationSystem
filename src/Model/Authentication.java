package Model;

import java.util.ArrayList;

public class Authentication {
    private ArrayList<UserAccount> authenticatedAccounts = new ArrayList<>();

    public Authentication() {
        UserAccount admin = new UserAccount("admin","admin");
        admin.setAdmin();
        authenticatedAccounts.add(admin);
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
        authenticatedAccounts.add(user);
    }

    public ArrayList<UserAccount> getAuthenticatedAccounts() {
        return authenticatedAccounts;
    }
}
