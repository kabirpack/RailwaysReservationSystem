package Db;

import Db.Interfaces.IRailwayDb;
import Model.PassengerTrain;
import Utilities.RailwayUtility;
import Model.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;

public class RailwayDb implements IRailwayDb {

    RailwayUtility utility = new RailwayUtility();
    private static ArrayList<PassengerTrain> trainList = new ArrayList<>();
    private ArrayList<UserAccount> accounts = new ArrayList<>();

    public  ArrayList<UserAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(UserAccount account){
        this.accounts.add(account);
    }
    public void setAccounts(ArrayList<UserAccount> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<PassengerTrain> getTrainList() {
        return trainList;
    }

    public void addTrainData(PassengerTrain train) {
        this.trainList.add(train);
    }

    public RailwayDb() {

        UserAccount admin = new UserAccount("admin","admin");
        admin.setAdmin();
        accounts.add(admin);


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

        addTrainData(train1);
        addTrainData(train2);
        addTrainData(train3);
    }
}
