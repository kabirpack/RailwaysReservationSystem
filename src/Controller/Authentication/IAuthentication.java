package Controller.Authentication;

import Model.UserAccount;

public interface IAuthentication {

    boolean validateUserName(String userName);
    boolean validateCredential(String userName, String password);
    UserAccount getUserAccount(String userName, String password);
    void register(UserAccount user);
}
