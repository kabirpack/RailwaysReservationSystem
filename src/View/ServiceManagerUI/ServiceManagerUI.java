package View.ServiceManagerUI;

import Controller.ServiceController;
import Model.PassengerTrain;
import Model.RailwayUtility;
import Model.ServicesManager;
import Model.Ticket;

import java.util.*;

public class ServiceManagerUI {
    RailwayUtility utility = new RailwayUtility();
    boolean done = false;
    Scanner sc = new Scanner(System.in);


    public void addService(ServicesManager sm, ServiceController serviceController) {
        while (!this.done) {
            try {
                System.out.println("Enter train number");
                String trainNum = utility.getStringInput();
                System.out.println("Enter train name");
                String trainName = sc.nextLine().toUpperCase(Locale.ROOT);
                System.out.println("Enter Train Capacity");
                int trainCapacity = sc.nextInt();
                ArrayList<String> trainSeats = utility.generateSeats(trainCapacity);
                System.out.println("Enter starting leg");
                String startLeg = utility.getStringInput();
                System.out.println("Enter ending leg");
                String endLeg = utility.getStringInput();
                PassengerTrain newTrain = new PassengerTrain(trainName, trainNum, startLeg, endLeg);
                newTrain.setAvailableSeats(trainSeats);
                System.out.println("Enter number of days availabe in a week");
                int daysCount = sc.nextInt();
                HashMap<String, String> timeTable = new HashMap<>();
                int i = 1;
                while (i < daysCount + 1) {
                    System.out.println("Enter day");
                    String day = utility.getStringInput().toUpperCase(Locale.ROOT);
                    System.out.println("Enter time (HH:mm)");
                    String time = utility.getStringInput();
                    if (!utility.isTimeFormatMatches(time)) {
                        throw new InputMismatchException("time format wrong");
                    }
                    timeTable.put(day, time);
                    i++;
                }
                newTrain.setTotalSeats(trainCapacity);
                newTrain.setTrainSchedule(timeTable);
                System.out.println("Enter no of Station stops");
                int routesCount = sc.nextInt();
                ArrayList<String> routes = new ArrayList<>();
                i = 1;
                while (i < routesCount + 1) {
                    System.out.println("Enter route");
                    String route = utility.getStringInput().toUpperCase(Locale.ROOT);
                    routes.add(route);
                    i++;
                }
                this.done = true;
                newTrain.setRoutes(routes);

                serviceController.addServiceControl(newTrain,sm);

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid input");
            }
        }
        PassengerTrain train = new PassengerTrain();
    }


    public void removeService(ServicesManager sm, ServiceController serviceController) {
        sm.showAllServices();
        this.done = false;
        while (!this.done) {
            try {
                System.out.println("choose train");
                int choice = sc.nextInt();
                if (choice > sm.getTrainList().size()) {
                    throw new InputMismatchException("");
                }
                System.out.println("Are you sure to remove");
                serviceController.removeServiceControl(sm,choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        }
    }

    public void holdService(ServicesManager sm, ServiceController serviceController){
        sm.showAllServices();
        this.done = false;
        while (!this.done) {
            try {
                System.out.println("choose train");
                int choice = sc.nextInt();
                if (choice > sm.getTrainList().size()) {
                    throw new InputMismatchException("");
                }
                System.out.println("Are you sure you want to remove?");
                serviceController.holdServiceControl(sm,choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        }
    }

    public void resumeService(ServicesManager sm, ServiceController serviceController){
        if(sm.getInactiveTrains().size()>0) {
            sm.showInactiveServices();
            this.done = false;
            while (!this.done) {
                try {
                    System.out.println("choose train");
                    int choice = sc.nextInt();
                    if (choice > sm.getInactiveTrains().size()) {
                        throw new InputMismatchException("");
                    }
                    System.out.println("Are you sure you want to resume?");
                    serviceController.resumeServiceControl(sm, choice);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                }

            }
        }else{
            System.out.println("No Inactive train found");
        }
    }

    public int printChooseService(ArrayList<PassengerTrain> trains){
        int siNo = 1;
        for (PassengerTrain train : trains) {
            System.out.print(siNo + ". " + train.getName() + " ");
            System.out.print(train.getTrainNumber() + " ");
            System.out.print(train.getSchedulebyDay(utility.getCurrentDay()) + " ");
            System.out.print(train.getRoutes() + " ");
            System.out.println();
            siNo++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("choose service");
        boolean done = false;
        while(!done){
            try{
                int choice = sc.nextInt();
                if(choice > trains.size()){
                    throw new InputMismatchException();
                }
                done = true;
                return choice;
            }
            catch(InputMismatchException e){
                System.out.println("please enter correct value");
            }
        }
        return 0;
    }

    public void printTrainChart(PassengerTrain train){
        System.out.println(train.getName() + " - " + train.getTrainNumber());
        int index = 1;
        for(Ticket ticket : train.getTickets()){
            if(ticket.isConfirmed()){
                System.out.println(index + ". " + ticket.getPnrNumber());
                for(String name : ticket.getSeatMap().keySet()){
                    System.out.print(name + " ");
                    System.out.print(ticket.getSeatMap().get(name) + " ");
                    System.out.println();
                }
                index++;
            }
        }
    }

}
