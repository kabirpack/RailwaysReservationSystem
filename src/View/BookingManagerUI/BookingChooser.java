package View.BookingManagerUI;

import Controller.BookingController.BookingManager;
import Controller.ServiceController.ServicesManager;
import Controller.Session.SessionController;
import Model.PassengerTrain;
import Model.Ticket;
import Model.UserAccount;
import Utilities.RailwayUtility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BookingChooser {
    BookingManager bm = new BookingManager();
    BookingUI bookUI = new BookingUI();
    ServicesManager sm = new ServicesManager();
    PassengerTrain chosenTrain;
    boolean isAvailableToday;
    RailwayUtility utility = new RailwayUtility();
    HashMap<String, String> passengerDetails = new HashMap<>();
    ArrayList<Ticket> finalTickets;
    ArrayList<PassengerTrain> availableTrains;


    public void bookToday(ArrayList<String> fromTo) throws ParseException {

        String day = utility.getCurrentDay();
        int choice  = bookUI.listServices(fromTo, day);
        availableTrains = sm.showAvailableServices(fromTo.get(0), fromTo.get(1 ),day);
        if(availableTrains.size()>0) {
            chosenTrain = availableTrains.get(choice - 1);
            Ticket ticket = new Ticket(utility.getCurrentDate(), fromTo.get(0), fromTo.get(1));
            ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
            isAvailableToday = chosenTrain.isBookingOpen(utility.getDayByDate(ticket.getTicketDate()), utility.getCurrentTime());
            if (isAvailableToday) {
                passengerDetails = bookUI.getPassengerDetails();
                finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
                SessionController.getUser().setMyTickets(finalTickets);
                bookUI.printAllTicket(SessionController.getUser());
            } else {
                System.out.println("Booking not available");
            }
        }
    }

    public void bookTomorrow(ArrayList<String> fromTo) throws ParseException {
        String day = utility.getNextDay();
        int choice  = bookUI.listServices(fromTo, day);
        availableTrains = sm.showAvailableServices(fromTo.get(0), fromTo.get(1 ),day);
        if(availableTrains.size()>0) {
            chosenTrain = availableTrains.get(choice - 1);
            Ticket ticket = new Ticket(utility.getNextDate(), fromTo.get(0), fromTo.get(1));
            ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
            passengerDetails = bookUI.getPassengerDetails();
            finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
            SessionController.getUser().setMyTickets(finalTickets);
            bookUI.printTicket(finalTickets);
        }
    }

    public void bookManualDate(ArrayList<String> fromTo) {
        boolean done = false;
        System.out.println("Enter date(format dd/mm/yyyy)");
        while (!done) {
            try {
                String date = utility.getStringInput();
                if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    throw new InputMismatchException("invalid");
                }
                String day = utility.getDayByDate(date);
                int choice  = bookUI.listServices(fromTo, day);
                availableTrains = sm.showAvailableServices(fromTo.get(0), fromTo.get(1 ),day);
                if(availableTrains.size()>0) {
                    chosenTrain = availableTrains.get(choice - 1);
                    Ticket ticket = new Ticket(date, fromTo.get(0), fromTo.get(1));
                    ticket.setRouteLength(sm.getRouteLength(fromTo.get(0), fromTo.get(1)));
                    passengerDetails = bookUI.getPassengerDetails();
                    finalTickets = bm.bookTicket(chosenTrain, SessionController.getUser(), ticket, passengerDetails);
                    SessionController.getUser().setMyTickets(finalTickets);
                    bookUI.printAllTicket(SessionController.getUser());
                }
                done = true;
            } catch (InputMismatchException | ParseException e) {
                System.out.println("Invalid Date format");
            }
        }
    }



    public void cancelTicket(UserAccount user) throws ParseException {
        Scanner sc = new Scanner(System.in);
        if (user.getMyTickets().size() > 0) {
            bookUI.printAllTicket(user);
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
