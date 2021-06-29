package View.BookingManagerUI;

import Model.Ticket;
import Model.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IBookingUI {

    ArrayList<String> getUserStation();
    int listServices(ArrayList<String>fromTo, String date) throws ParseException;
    HashMap<String, String> getPassengerDetails();
    void printTicket(ArrayList<Ticket> tickets);
    void printAllTicket(UserAccount user) throws ParseException;


}
