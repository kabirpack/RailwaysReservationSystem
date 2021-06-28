package Controller;

import Model.Authentication;
import Model.ServicesManager;
import View.BookingManagerUI.BookingUI;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;

import java.text.ParseException;
import java.util.ArrayList;

public class UserMenuController {
    RailwaysMenu menu = new RailwaysMenu();
    BookingUI bookUI = new BookingUI();
    BookingController bc = new BookingController();
    ArrayList<String> fromTo = new ArrayList<>();
    Authentication auth = new Authentication();
    ServicesManager sm = new ServicesManager();

    public void userMenuController() throws ParseException {
        int choice = menu.showRailwayMenu(MenuItems.userMenu.class);
        switch (choice){
            case 1:{
            fromTo = bookUI.getUserStation(sm);
            choice = menu.showRailwayMenu(MenuItems.ticketDateChooser.class);
            switch (choice){
                case 1:{
                    bc.bookToday(fromTo, sm);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
                case 2:{
                    bc.bookTomorrow(fromTo, sm);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
                case 3:{
                    bc.bookManual(fromTo, sm);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
            }
            return;
            }
            case 2:{
                    bc.cancelTicket(SessionController.getUser(), sm);
                if(!SessionController.getUser().isAdmin()) {
                    this.userMenuController();
                }
                    return;
            }
            case 3:{
                    bookUI.printAllTicket(SessionController.getUser(), sm);
                if(!SessionController.getUser().isAdmin()) {
                    this.userMenuController();
                }
                    return;
            }
            case 4:{
            SessionController.logOut();
                return;
            }
        }
    }

}
