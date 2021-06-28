package Controller;

import Db.RailwayDb;
import Model.UserAccount;
import View.AuthenticationMenu.AuthenticationMenu;

import java.text.ParseException;

public class SessionController {

    private static UserAccount user;
    private static RailwayDb db;

    public static RailwayDb getDb() {
        return db;
    }

    public static void setDb(RailwayDb db) {
        SessionController.db = db;
    }

    public static UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public static void logOut() throws ParseException {
        AuthenticationMenu authMenu = new AuthenticationMenu();
        authMenu.authenticationMenu();
    }


}
