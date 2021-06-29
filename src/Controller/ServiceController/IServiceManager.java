package Controller.ServiceController;

import Model.PassengerTrain;

import java.util.ArrayList;

public interface IServiceManager {

    boolean addService(PassengerTrain train);
    void showAllServices();
    ArrayList<PassengerTrain> showAvailableServices(String from, String to, String day);
    ArrayList<PassengerTrain> getActiveServices();
    ArrayList<PassengerTrain> getInactiveTrains();
    void showInactiveServices();
    void removeService(PassengerTrain train);
    void holdService(PassengerTrain train);
    void resumeService(PassengerTrain train);
    PassengerTrain getTrainByNumber(String number);
    boolean isStationAvailable(String station);
    String getStationFromSubstring(String station);
    int getRouteLength(String from, String to);
    void printRoutes();
    void prepareChart();
    boolean isRouteValid(String from, String to);
}
