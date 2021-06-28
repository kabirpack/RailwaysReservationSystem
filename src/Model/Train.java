package Model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Train {
    private String name;
    private String trainNumber;
    private String startLeg;
    private String endLeg;
    private int compartmentCount;
    private boolean isActive;
    private HashMap<String, String> trainSchedule = new HashMap<>();
    private ArrayList<String> routes = new ArrayList<>();

    public Train() {

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public HashMap<String, String> getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(HashMap<String, String> trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public Train(String name, String trainNumber, String startLeg, String endLeg) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.startLeg = startLeg;
        this.endLeg = endLeg;
        this.isActive = true;
    }

    public boolean isAvailable(String day){
        for(String availableDay : trainSchedule.keySet()){
            if (day.equals(availableDay)){
                return true;
            }
        }
        return false;
    }

    public void setRoutes(ArrayList<String> routes) {
        this.routes = routes;
    }

    public String getSchedulebyDay(String day){
        return trainSchedule.get(day);
    }


    public void showSchedule(){
        System.out.println(trainSchedule);
    }

    public String getName() {
        return name;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }
}
