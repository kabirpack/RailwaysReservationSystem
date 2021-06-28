package Db;

import Model.PassengerTrain;
import Model.RailwayUtility;

import java.util.ArrayList;
import java.util.HashMap;

public class RailwayDb {

    RailwayUtility utility = new RailwayUtility();
    private ArrayList<PassengerTrain> trainArchives = new ArrayList<>();

    public ArrayList<PassengerTrain> getTrainArchives() {
        return trainArchives;
    }

    public void addToTrainArchives(PassengerTrain train) {
        this.trainArchives.add(train);
    }

    public RailwayDb() {



        PassengerTrain train1 = new PassengerTrain("JanShathapthi","342325345","mayiladuthurai","coimbatore");
        ArrayList<String> routes = new ArrayList<>();
        routes.add("MAYILADUTHURAI");
        routes.add("KUMBAKONAM");
        routes.add("TANJORE");
        routes.add("TRICHY");
        routes.add("ERODE");
        routes.add("COIMBATORE");
        train1.setRoutes(routes);
        train1.setAvailableSeats(utility.generateSeats(20));
        train1.setTotalSeats(20);
        HashMap<String,String> schedule = new HashMap<>();
        schedule.put("MONDAY","15:30");
        schedule.put("TUESDAY","15:30");
        schedule.put("WEDNESDAY","15:30");
        schedule.put("THURSDAY","15:30");
        schedule.put("FRIDAY","15:30");
        schedule.put("SATURDAY","15:30");
        schedule.put("SUNDAY","15:30");
        train1.setTrainSchedule(schedule);


        PassengerTrain train2 = new PassengerTrain("ChennaiExpress","453454677","Chidambaram","Chennai");
         routes = new ArrayList<>();
        routes.add("CHIDAMBARAM");
        routes.add("CUDDALORE");
        routes.add("PONDICHERRY");
        routes.add("DINDIVANAM");
        routes.add("MAMANDUR");
        routes.add("CHENNAI");
        train2.setRoutes(routes);
        train2.setAvailableSeats(utility.generateSeats(20));
        train2.setTotalSeats(20);
        schedule = new HashMap<>();
        schedule.put("MONDAY","15:30");
        schedule.put("TUESDAY","15:30");
        schedule.put("WEDNESDAY","15:30");
        schedule.put("THURSDAY","15:30");
        schedule.put("FRIDAY","15:30");
        schedule.put("SATURDAY","15:30");
        schedule.put("SUNDAY","15:30");
        train2.setTrainSchedule(schedule);


        PassengerTrain train3 = new PassengerTrain("RAMESHWARAMEXPRESS","45345467","MANNARKUDI","RAMESHWARAM");
        routes = new ArrayList<>();
        routes.add("MANNARKUDI");
        routes.add("SIRKALI");
        routes.add("TRICHY");
        routes.add("MADURAI");
        routes.add("RAMANATHAPURAM");
        routes.add("RAMESHWARAM");
        train3.setRoutes(routes);
        train3.setAvailableSeats(utility.generateSeats(20));
        train3.setTotalSeats(20);
        schedule = new HashMap<>();
        schedule.put("MONDAY","15:30");
        schedule.put("TUESDAY","15:30");
        schedule.put("WEDNESDAY","15:30");
        schedule.put("THURSDAY","15:30");
        schedule.put("FRIDAY","15:30");
        schedule.put("SATURDAY","15:30");
        schedule.put("SUNDAY","15:30");
        train3.setTrainSchedule(schedule);

        addToTrainArchives(train1);
        addToTrainArchives(train2);
        addToTrainArchives(train3);
    }
}
