package Model;

import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingManager {
RailwaysMenu menu = new RailwaysMenu();
RailwayUtility utility = new RailwayUtility();
int prompt;


    public ArrayList<Ticket> bookTicket(PassengerTrain selectedTrain, UserAccount user, Ticket ticket , HashMap<String, String> passengers) throws ParseException {
        ArrayList<Ticket> resultArray = new ArrayList<>();
            ticket.setTrainName(selectedTrain.getName());
            ticket.setTrainNumber(selectedTrain.getTrainNumber());
            ticket.setDepartureTime(selectedTrain.getSchedulebyDay(utility.getDayByDate(ticket.getTicketDate())));
            int availableSeats = selectedTrain.getAvailableSeats().size();
            int passengerCount = passengers.size();

            if(availableSeats == 0){
                if(selectedTrain.getWlSeats() >= passengerCount){
                    System.out.println("Only Waiting list available");
                    System.out.println("Waiting List position" + selectedTrain.getWaitingList().size() + 1 + " available");
                    prompt = menu.showRailwayMenu(MenuItems.yesOrNo.class);
                    if(prompt == 1){
                        resultArray.add(bookWlTickets(selectedTrain,passengerCount,ticket, passengers));
                        return resultArray;
                    }
                }else{
                    System.out.println("Only " + selectedTrain.getWlSeats() + "Waiting list ticket available\nDo you wish to continue?");
                    prompt = menu.showRailwayMenu(MenuItems.yesOrNo.class);
                    if(prompt == 1){
                        resultArray.add(bookConfirmedTicket(selectedTrain,passengerCount,ticket, passengers));
                        return resultArray;
                    }
                }

            }else if(availableSeats == 0  && selectedTrain.getWlSeats() == 0){
                System.out.println("All tickets are booked, sorry.");
            }
            if(availableSeats < passengerCount){
                int potentialWL = Math.abs(availableSeats - passengerCount);
                System.out.println("only " + availableSeats + "seats are available, remaining "+ potentialWL + "seats can be booked in waiting list");

                int ticketChoice = menu.showRailwayMenu(MenuItems.ticketSeparation.class);
                switch (ticketChoice){
                    case 1:{
                        resultArray.add(bookConfirmedTicket(selectedTrain,availableSeats,ticket, passengers));
                        resultArray.add(bookWlTickets(selectedTrain,potentialWL,ticket, passengers));
                        return resultArray;
                    }
                    case 2:{
                        resultArray.add(bookConfirmedTicket(selectedTrain,availableSeats,ticket, passengers));
                        return resultArray;
                    }
                }
            }else{
                resultArray.add(bookConfirmedTicket(selectedTrain,passengerCount,ticket, passengers));
                return resultArray;
            }
        return resultArray;
    }



    public Ticket bookWlTickets(PassengerTrain train,int psngCount, Ticket ticket, HashMap<String, String> passengers){
        ticket.setPassengerList(passengers);
        ticket.setPnrNumber(utility.generatePnrNumber());
        ticket.setStatus("WAITINGLIST");
        ticket.setConfirmed(false);
        train.addWaitingList(ticket.getPnrNumber());
        train.decrementWlSeats(psngCount);
        train.getTickets().add(ticket);
        return ticket;
    }

    public Ticket bookConfirmedTicket(PassengerTrain train, int psngCount, Ticket ticket, HashMap<String, String> passengers){
        ticket.setPnrNumber(utility.generatePnrNumber());
        ArrayList<String> pnrSeatMap = new ArrayList<>();
        HashMap<String,String> seatMap = new HashMap<>();
        int i=0;
        for(String psngr : passengers.keySet()){
            seatMap.put(psngr,train.getAvailableSeats().get(i));
            pnrSeatMap.add(train.getAvailableSeats().get(i));
            i=i+1;
        }
        int length = passengers.keySet().size();
        for(int j=0; j<length;  j++){
            train.removeAvailableSeat(j);
            length--;
        }
        ticket.setSeatMap(seatMap);
        ticket.setPassengerList(passengers);
        ticket.setStatus("CONFIRMED");
        ticket.setConfirmed(true);
        train.addBookedSeats(ticket.getPnrNumber(),pnrSeatMap);
        train.decrementTotalSeats(psngCount);
        train.getTickets().add(ticket);
        return ticket;
    }

    public void cancelTicket(PassengerTrain train, Ticket ticket, int passengerCount){
        System.out.println("before cancelling booked pnr" + train.getBookedSeats());
        train.removeBookedSeats(ticket.getPnrNumber());
        System.out.println("after cancelling booked pnr" + train.getBookedSeats());
        System.out.println("before cancelling total seats" + train.getTotalSeats());
        train.incrementTotalSeats(passengerCount);
        System.out.println("after cancelling total seats" + train.getTotalSeats());
        System.out.println("before cancelling available seats" + train.getAvailableSeats());
        for(String seat : ticket.getSeatMap().values()){
            train.getAvailableSeats().add(seat);
        }
        System.out.println("after cancelling available seats" + train.getAvailableSeats());
    }


}
