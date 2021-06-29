package Model.Interfaces;

import java.text.ParseException;

public interface IPassengerTrain {
    boolean isBookingOpen(String day, String time) throws ParseException;
}
