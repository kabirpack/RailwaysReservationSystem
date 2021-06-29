package View.ServiceManagerUI;

import Model.PassengerTrain;

import java.util.ArrayList;

public interface IServiceManagerUI {

    void addService();
    void removeService();
    void holdService();
    void resumeService();
    void printServices(ArrayList<PassengerTrain> trains);
    int printChooseService(ArrayList<PassengerTrain> trains);
    void printTrainChart(PassengerTrain train);
}
