package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PassengerTrain extends Train{

    private int totalSeats;
    private int acSeats;
    private int wlSeats = 20;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private HashMap<String, ArrayList<String>> bookedSeats = new HashMap<>();  // may change to hash map to map pnr to seats
    private ArrayList<String> availableSeats = new ArrayList<>();
    private ArrayList<String> waitingList = new ArrayList<>(); // contain pnr number
    private final int thresholdBookingTime = 3;
    public PassengerTrain(String name, String trainNumber, String startLeg, String endLeg) {
        super(name, trainNumber, startLeg, endLeg);
    }

    public PassengerTrain() {
        super();
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public boolean isBookingOpen(String day, String time) throws ParseException {
        if(isAvailable(day)){

            String scheduleTimeStr = getTrainSchedule().get(day);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            // may need try catch
            Date scheduleTime = simpleDateFormat.parse(scheduleTimeStr);
            Date currentTime = simpleDateFormat.parse(time);
            long timeDifferenceMS = Math.abs(scheduleTime.getTime() - currentTime.getTime());
            long timeDifference = (timeDifferenceMS / (60 * 60 * 1000));

            if(timeDifference < thresholdBookingTime){
                return false;
            }
        }
        return true;
    }

    public boolean isSeatAvailable(String seat){
        for(ArrayList<String> bookedSeat : bookedSeats.values()){
            for(String seats : bookedSeat) {
                if (seat.equals(bookedSeat)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void decrementTotalSeats(int seat) {
        this.totalSeats = totalSeats-seat;
    }

    public void incrementTotalSeats(int seat) {
        this.totalSeats = totalSeats+seat;
    }


    public void setAcSeats(int acSeats) {
        this.acSeats = acSeats;
    }

    public void decrementWlSeats(int seats) {
        this.wlSeats = wlSeats-seats ;
    }

    public void incrementWlSeats() {
        this.wlSeats = wlSeats+1 ;
    }

    public void setBookedSeats(HashMap<String, ArrayList<String>> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void removeBookedSeats(String pnr) {
        this.bookedSeats.remove(pnr);
    }

    public void removeAvailableSeat(int i){
        this.availableSeats.remove(i);
    }


    public void setAvailableSeats(ArrayList<String> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void addWaitingList(String pnr) {
        this.waitingList.add(pnr);
    }


    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAcSeats() {
        return acSeats;
    }

    public int getWlSeats() {
        return wlSeats;
    }

    public HashMap<String, ArrayList<String>> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeats(String pnr,ArrayList<String> seats){
        this.bookedSeats.put(pnr,seats);
    }

    public ArrayList<String> getAvailableSeats() {
        return availableSeats;
    }

    public int getThresholdBookingTime() {
        return thresholdBookingTime;
    }

    public ArrayList<String> getWaitingList() {
        return waitingList;
    }}
