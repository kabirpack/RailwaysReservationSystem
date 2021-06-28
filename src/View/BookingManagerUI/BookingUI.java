package View.BookingManagerUI;

import Model.*;

import java.text.ParseException;
import java.util.*;

public class BookingUI implements IBookingUI {
    boolean done = false;
    RailwayUtility utility = new RailwayUtility();
    ArrayList<String> fromTo = new ArrayList<>();
    ArrayList<PassengerTrain> availableTrains = new ArrayList<>();
//    Scanner sc = new Scanner(System.in);


    @Override
    public ArrayList<String> getUserStation(ServicesManager sm) {
        int fromIndex;
        int toIndex;
        Scanner sc = new Scanner(System.in);
        this.done = false;
        while (!this.done) {
            try {
                System.out.println("From");
                String from = utility.getStringInput().toUpperCase(Locale.ROOT);
                if (!sm.isStationAvailable(from)) {
                    System.out.println("Only following routes available");
                    sm.printRoutes();
                    throw new InputMismatchException("");
                } else {
                    from = sm.getStationFromSubstring(from);
                    fromTo.add(from);

                }

                System.out.println("To");
                String to = utility.getStringInput().toUpperCase(Locale.ROOT);
                if (!sm.isStationAvailable(to)) {
                    System.out.println("Only following routes available");
                    sm.printRoutes();
                    throw new InputMismatchException("");
                } else {
                    to = sm.getStationFromSubstring(to);
                    fromTo.add(to);
                }

                if (from.equals(to)) {
                    System.out.println("From and To cannot be same");
                    throw new InputMismatchException();
                }
                if (sm.getRouteLength(from, to) < 0){
                    System.out.println("No trains available for this route");
                    throw new InputMismatchException();
                }
                this.done = true;
            } catch (InputMismatchException e) {
                System.out.println("Please give valid input");
            }

        }
        return fromTo;
    }

    @Override
    public PassengerTrain listServices(ArrayList<String>fromTo, UserAccount user, ServicesManager sm, String day) throws ParseException {
        String from = fromTo.get(0);
        String to = fromTo.get(1);
        availableTrains = sm.showAvailableServices(fromTo.get(0), fromTo.get(1 ),day);
        if (availableTrains.size() > 0) {
            int siNo = 1;
            for (PassengerTrain train : availableTrains) {
                System.out.print(siNo + ". " + train.getName() + " ");
                System.out.print("Departure " + train.getSchedulebyDay(day) + " ");
                System.out.print(train.getRoutes() + " ");
                System.out.println();
                siNo++;
            }
        }
        System.out.println("choose a service");
        int arrayLength = availableTrains.size();
        int choice = 1 ;
        try{
            choice = utility.getIntInput();
            if(choice > arrayLength){
                throw new InputMismatchException("invalid");
            }
        }
        catch(InputMismatchException e){
            System.out.println("please input correct choice");
        }
        PassengerTrain chosenTrain = availableTrains.get(choice - 1);
        return chosenTrain;
    }
    @Override
    public HashMap<String, String> getPassengerDetails(){
        HashMap<String,String> passengers = new HashMap<>();
        System.out.println("Enter Number of passengers");
        boolean done = false;
        while(!done) {
            try {
                int passengerCount = utility.getIntInput();
                if(passengerCount > 6){
                    System.out.println("At most 6 tickets allowed for a booking");
                    throw new InputMismatchException();
                }
                done = true;
                for (int i = 0; i < passengerCount; i++) {
                    System.out.println("Passenger Name");
                    String passengerName = utility.getStringInput();
                    System.out.println("Passenger Age");
                    String passengerAge = utility.getStringInput();
                    passengers.put(passengerName, passengerAge);
                }
            }catch(InputMismatchException e){
                System.out.println("Enter correct value");
            }
        }
        return passengers;
    }
    @Override
    public void printTicket(ArrayList<Ticket> tickets){
        int index = 1;
        for (Ticket ticket : tickets) {
            System.out.print(index + ". " + ticket.getPnrNumber() + " ");
            System.out.print(ticket.getTrainName() + " ");
            System.out.print(ticket.getFrom() + " to " + ticket.getTo() + " ");
            System.out.print(ticket.getTicketDate() + " ");
            System.out.print(ticket.getDepartureTime() + " ");
            System.out.print(ticket.getPassengerList() + " ");
            System.out.print(ticket.getSeatMap() + " ");
            System.out.print(ticket.getStatus() + " ");
            System.out.println(" ");
            index++;
        }
    }
    @Override
    public void printAllTicket(UserAccount user, ServicesManager sm) throws ParseException {
        if(user.getMyTickets().size() > 0) {
            int index = 1;
            for (Ticket ticket : user.getMyTickets()) {
                System.out.print(index + ". " + ticket.getPnrNumber() + " ");
                System.out.print(ticket.getTrainName() + " ");
                System.out.print(ticket.getFrom() + " to " + ticket.getTo() + " ");
                System.out.print(ticket.getTicketDate() + " ");
                System.out.print(ticket.getDepartureTime() + " ");
                System.out.print(ticket.getPassengerList() + " ");
                System.out.print(ticket.getSeatMap() + " ");
                System.out.print(ticket.getStatus() + " ");
                System.out.println(" ");
                index++;
            }
        }else{
            System.out.println("No active Tickets");
        }
    }



}