package Model;

import java.util.HashMap;

public class Ticket {

    private String pnrNumber;
    private String trainName;
    private String trainNumber;
    private String ticketDate;
    private String departureTime;
    private String from;
    private String to;
    private int routeLength;
    private HashMap<String, String> passengerList = new HashMap<>();
    private HashMap<String, String> seatMap = new HashMap<>();
    private String status;
    private boolean isConfirmed;

    public Ticket(String ticketDate, String from, String to) {
        this.ticketDate = ticketDate;
        this.from = from;
        this.to = to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public HashMap<String, String> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(HashMap<String, String> seatMap) {
        this.seatMap = seatMap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public HashMap<String, String> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(HashMap<String, String> passengerList) {
        this.passengerList = passengerList;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
