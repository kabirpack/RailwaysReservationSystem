import Controller.AuthenticationController;
import Db.RailwayDb;
import Model.Authentication;
import Model.ServicesManager;

import java.text.ParseException;

public class ReservationSystemMain {
    public static void main(String[] args) throws ParseException {
        Authentication auth = new Authentication();
        ServicesManager sm = new ServicesManager();
        RailwayDb db = new RailwayDb();
        sm.setTrainList(db.getTrainArchives());
        AuthenticationController controller = new AuthenticationController();
        controller.authenticationController(auth, sm);
        controller.setAuthSession(auth);
    }
}
