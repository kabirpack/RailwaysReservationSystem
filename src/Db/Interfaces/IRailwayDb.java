package Db.Interfaces;

import Model.PassengerTrain;
import Model.UserAccount;

import java.util.ArrayList;

public interface IRailwayDb {
    ArrayList<UserAccount> getAccounts();
    void addAccount(UserAccount account);
    void setAccounts(ArrayList<UserAccount> accounts);
    ArrayList<PassengerTrain> getTrainList();
    void addTrainData(PassengerTrain train);
}
