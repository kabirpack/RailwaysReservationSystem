package View.RailwayMenu;

public class MenuItems {

    public enum adminMenu {
        MANAGE_SERVICE,
        MANAGE_TICKET,
        PREPARE_CHART,
        LOGOUT
    }

    public enum userMenu {
        BOOK_TICKET,
        CANCEL_TICKET,
        SHOW_TICKETS,
        LOGOUT
    }

     public enum landingMenu {
        REGISTER,
        LOGIN
    }

    public enum manageServiceMenu{
        ADD_SERVICE,
        REMOVE_SERVICE,
        HOLD_SERVICE,
        RESUME_SERVICE,
        SHOW_ALLSERVICE,
        LOGOUT
    }

    public enum ticketDateChooser{
        TODAY,
        TOMORROW,
        ENTER_DATE_MANUALLY,
        LOGOUT
    }

    public enum yesOrNo{
        YES,
        NO
    }

    public enum ticketSeparation{
        BOOK_ALL_TICKET,
        BOOK_CONFIRMED_TICKET
    }


}
