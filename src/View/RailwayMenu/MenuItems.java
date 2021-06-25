package View.RailwayMenu;

public class MenuItems {

    enum adminMenu {
        MANAGE_SERVICE,
        MANAGE_TICKET,
        LOGOUT
    }

    enum userMenu {
        BOOK_TICKET,
        CANCEL_TICKET,
        LOGOUT
    }

    enum landingMenu {
        REGISTER,
        LOGIN
    }

    enum manageServiceMenu{
        ADD_SERVICE,
        REMOVE_SERVICE,
        HOLD_SERVICE,
        RESUME_SERVICE,
        SHOW_ALLSERVICE
    }

    enum ticketDateChooser{
        TODAY,
        TOMORROW,
        ENTER_DATE_MANUALLY
    }

}
