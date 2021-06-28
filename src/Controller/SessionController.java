package Controller;

import Model.Authentication;
import Model.ServicesManager;
import Model.UserAccount;

import java.text.ParseException;

public class SessionController {

    private static UserAccount user;

    public static UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public static void logOut(Authentication auth, ServicesManager sm) throws ParseException {
        AuthenticationController authCon = new AuthenticationController();
        authCon.authenticationController(auth, sm);
    }


}
