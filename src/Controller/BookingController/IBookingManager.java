package Controller.BookingController;

import Model.PassengerTrain;
import Model.Ticket;

import java.util.HashMap;

public interface IBookingManager {
    Ticket bookWlTickets(PassengerTrain train, int psngCount, Ticket ticket, HashMap<String, String> passengers);
    Ticket bookConfirmedTicket(PassengerTrain train, int psngCount, Ticket ticket, HashMap<String, String> passengers);
    void cancelTicket(PassengerTrain train, Ticket ticket, int passengerCount);
    void confirmWaitingTicket(PassengerTrain train);
}
