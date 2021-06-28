package Controller;

import Model.*;
import View.BookingManagerUI.BookingUI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BookingController {
    BookingManager bm = new BookingManager();
    BookingUI bookUI = new BookingUI();
    PassengerTrain chosenTrain;
    boolean isAvailableToday;
    RailwayUtility utility = new RailwayUtility();
//    UserAccount user = SessionController.getUser();
    HashMap<String, String> passengerDetails = new HashMap<>();
    ArrayList<Ticket> finalTickets;


    public void bookToday(ArrayList<String> fromTo, ServicesManager sm) throws ParseException {

        String day = SessionController.getUser().getSessionDay();
        chosenTrain = bookUI.listServices(fromTo, SessionController.getUser(), sm, day);
        Ticket ticket = new Ticket(utility.getCurrentDate(), fromTo.get(0), fromTo.get(1));
        ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
        isAvailableToday = chosenTrain.isBookingOpen(utility.getDayByDate(ticket.getTicketDate()), SessionController.getUser().getSessionTime());
        if (isAvailableToday) {
            passengerDetails = bookUI.getPassengerDetails();
            finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
            SessionController.getUser().setMyTickets(finalTickets);
            bookUI.printAllTicket(SessionController.getUser(), sm);
        } else {
            System.out.println("Booking not available");
        }

    }

    public void bookTomorrow(ArrayList<String> fromTo, ServicesManager sm) throws ParseException {
        String day = utility.getNextDay();
        chosenTrain = bookUI.listServices(fromTo, SessionController.getUser(), sm, day);
        Ticket ticket = new Ticket(utility.getNextDate(), fromTo.get(0), fromTo.get(1));
        ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
        passengerDetails = bookUI.getPassengerDetails();
        finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
        SessionController.getUser().setMyTickets(finalTickets);
        bookUI.printTicket(finalTickets);
    }

    public void bookManual(ArrayList<String> fromTo, ServicesManager sm) {
        boolean done = false;
        System.out.println("Enter date(format dd/mm/yyyy)");
        while (!done) {
            try {
                String date = utility.getStringInput();
                if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    throw new InputMismatchException("invalid");
                } else {
                    chosenTrain = bookUI.listServices(fromTo, SessionController.getUser(), sm, date);
                    Ticket ticket = new Ticket(date, fromTo.get(0), fromTo.get(1));
                    ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
                    passengerDetails = bookUI.getPassengerDetails();
                    finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
                    SessionController.getUser().setMyTickets(finalTickets);
                    bookUI.printAllTicket(SessionController.getUser(), sm);
                }
            } catch (InputMismatchException | ParseException e) {
                System.out.println("Invalid Date format");
            }
        }
    }



    public void cancelTicket(UserAccount user, ServicesManager sm) throws ParseException {
        Scanner sc = new Scanner(System.in);
        if (user.getMyTickets().size() > 0) {
            bookUI.printAllTicket(user,sm);
            System.out.println("Choose ticket to cancel");
            int choice = sc.nextInt();
            Ticket ticketToCancel = user.getMyTickets().get(choice - 1);
            user.removeTickets(choice - 1);
            if (ticketToCancel.getStatus().equals("CONFIRMED")) {
                PassengerTrain trainToCancel = sm.getTrainByNumber(ticketToCancel.getTrainNumber());
                bm.cancelTicket(trainToCancel, ticketToCancel, ticketToCancel.getPassengerList().size());
            }
        } else {
            System.out.println("No tickets to cancel.");
        }
    }

}
