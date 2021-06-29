package View.UserMenu;

import Controller.BookingController.BookingValidator;
import Controller.Session.SessionController;
import View.BookingManagerUI.BookingUI;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;

import java.text.ParseException;
import java.util.ArrayList;

public class UserMenu {
    RailwaysMenu menu = new RailwaysMenu();
    BookingUI bookUI = new BookingUI();
    BookingValidator bookingValidator = new BookingValidator();
    ArrayList<String> fromTo = new ArrayList<>();

    public void userMenuController() throws ParseException {
        int choice = menu.showRailwayMenu(MenuItems.userMenu.class);
        switch (choice){
            case 1:{
            fromTo = bookUI.getUserStation();
            choice = menu.showRailwayMenu(MenuItems.ticketDateChooser.class);
            switch (choice){
                case 1:{
                    bookingValidator.bookToday(fromTo);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
                case 2:{
                    bookingValidator.bookTomorrow(fromTo);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
                case 3:{
                    bookingValidator.bookManualDate(fromTo);
                    if(!SessionController.getUser().isAdmin()) {
                        this.userMenuController();
                    }
                    return;
                }
            }
            return;
            }
            case 2:{
                    bookingValidator.cancelTicket(SessionController.getUser());
                if(!SessionController.getUser().isAdmin()) {
                    this.userMenuController();
                }
                    return;
            }
            case 3:{
                    bookUI.printAllTicket(SessionController.getUser());
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
