package Model;

import java.util.ArrayList;

public class ServicesManager {

    private ArrayList<PassengerTrain> trainList = new ArrayList<>();


    public boolean addService(PassengerTrain train){
        if(trainList.add(train)){
            return true;
        }
        return false;
    }

    public void showAllServices(){
        int siNo = 1;
        for (PassengerTrain train : this.trainList) {
            System.out.print(siNo + ". " + train.getName() + " ");
            System.out.print(train.getTrainSchedule() + " ");
            System.out.print(train.getRoutes() + " ");
            System.out.println();
            siNo++;
        }
    }

    public ArrayList<PassengerTrain> getActiveServices(){
        ArrayList<PassengerTrain> trains = new ArrayList<>();
        for (PassengerTrain train : this.trainList) {
            if(train.isActive()){
                trains.add(train);
            }
        }
        return trains;
    }

    public void showInactiveServices(){
        int siNo = 1;
        for (PassengerTrain train : this.getInactiveTrains()) {
            System.out.print(siNo + ". " + train.getName() + " ");
            System.out.print(train.getTrainSchedule() + " ");
            System.out.print(train.getRoutes() + " ");
            System.out.println();
            siNo++;
        }
    }

    public void removeService(PassengerTrain train){
        trainList.remove(train);
        System.out.println("Train removed successfully");
    }

    public void holdService(PassengerTrain train){
        train.setActive(false);
        System.out.println("Train holded successfully");
    }

    public void resumeService(PassengerTrain train){
        train.setActive(true);
        System.out.println("Train resumed successfully");
    }

    public ArrayList<PassengerTrain> getInactiveTrains(){
        ArrayList<PassengerTrain> availableTrains = new ArrayList<>();
        for(PassengerTrain train : trainList){
            if(!train.isActive()){
                availableTrains.add(train);
            }

        }
        return availableTrains;
    }


    public ArrayList<PassengerTrain> showAvailableServices(String from, String to, String day){
        ArrayList<PassengerTrain> availableTrains = new ArrayList<>();
        for(PassengerTrain train : trainList){
            if(train.isActive() && train.isAvailable(day)){
                if(train.getRoutes().contains(from) && train.getRoutes().contains(to)){
                    availableTrains.add(train);
                }
            }
        }
        return availableTrains;
    }

    public ArrayList<PassengerTrain> getTrainList() {
        return trainList;
    }

    public void setTrainList(ArrayList<PassengerTrain> trainList) {
        this.trainList = trainList;
    }

    public PassengerTrain getTrainByNumber(String number){
        for(PassengerTrain train : trainList){
            if(train.getTrainNumber().equals(number)){
                PassengerTrain train1 = train;
                return train1;
            }
        }

        return null;
    }

    public boolean isStationAvailable(String station){
        if(station.length() >= 4) {
            for (PassengerTrain train : trainList) {
                if (train.isActive()) {
                    for (String route : train.getRoutes()) {
                        if (route.contains(station)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getStationFromSubstring(String station){
        if(station.length() >= 4) {
            for (PassengerTrain train : trainList) {
                if (train.isActive()) {
                    for (String route : train.getRoutes()) {
                        if (route.contains(station)) {
                            return route;
                        }
                    }
                }
            }
        }
        return "";
    }

    public void printRoutes(){
        for(PassengerTrain train : trainList){
            if(train.isActive()){
                System.out.println(train.getRoutes());
            }
        }

    }

    public void printFromLocations(){
        for(PassengerTrain train : trainList){
            if(train.isActive()){
                for(int i=0; i<train.getRoutes().size()-1;i++){
                    System.out.print(train.getRoutes().get(i) + ",");
                    System.out.println(" ");
                }
            }
        }
    }

    public void printToLocations(){
        for(PassengerTrain train : trainList){
            if(train.isActive()){
                for(int i=1; i<train.getRoutes().size();i++){
                    System.out.print(train.getRoutes().get(i) + ",");
                    System.out.println(" ");
                }
            }
        }
    }

}