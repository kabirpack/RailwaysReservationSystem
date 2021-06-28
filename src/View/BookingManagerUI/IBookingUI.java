package View.BookingManagerUI;

import Model.PassengerTrain;
import Model.ServicesManager;
import Model.Ticket;
import Model.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IBookingUI {

    ArrayList<String> getUserStation(ServicesManager sm);
    PassengerTrain listServices(ArrayList<String>fromTo, UserAccount user, ServicesManager sm, String date) throws ParseException;
    HashMap<String, String> getPassengerDetails();
    void printTicket(ArrayList<Ticket> tickets);
    void printAllTicket(UserAccount user, ServicesManager sm) throws ParseException;


}
