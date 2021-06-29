package Main;

import Controller.Session.SessionController;
import Db.RailwayDb;
import View.AuthenticationMenu.AuthenticationMenu;

import java.text.ParseException;

public class ReservationSystemMain {
    public static void main(String[] args) throws ParseException {
        RailwayDb db = new RailwayDb();
        SessionController.setDb(db);
        AuthenticationMenu menu = new AuthenticationMenu();
        menu.authenticationMenu();
    }
}
