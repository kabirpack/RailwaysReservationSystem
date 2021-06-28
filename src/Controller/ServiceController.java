package Controller;

import Model.PassengerTrain;
import Model.ServicesManager;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;
import View.ServiceManagerUI.ServiceManagerUI;

import java.util.ArrayList;

public class ServiceController {
    RailwaysMenu menu = new RailwaysMenu();

    public void addServiceControl(PassengerTrain train, ServicesManager sm){
        if(sm.addService(train)){
            System.out.println("Train added Successfully");
        }else {
            System.out.println("Train failed to get added");
        }
    }

    public void removeServiceControl(ServicesManager sm, int choice){
        int prompt = menu.showRailwayMenu(MenuItems.yesOrNo.class);
        if (prompt == 1) {
            sm.removeService(sm.getTrainList().get(choice - 1));
        }
    }

    public void holdServiceControl(ServicesManager sm, int choice){
        int prompt = menu.showRailwayMenu(MenuItems.yesOrNo.class);
        if (prompt == 1) {
            sm.holdService(sm.getTrainList().get(choice - 1));
        }
    }

    public void resumeServiceControl(ServicesManager sm, int choice){
        int prompt = menu.showRailwayMenu(MenuItems.yesOrNo.class);
        if (prompt == 1) {
            sm.resumeService(sm.getTrainList().get(choice - 1));
        }
    }

    public void prepareChart(ServicesManager sm){
        ServiceManagerUI smUI = new ServiceManagerUI();
        ArrayList<PassengerTrain> activeTrains = new ArrayList<>();
        activeTrains = sm.getActiveServices();
        int choice = smUI.printChooseService(activeTrains);
        smUI.printTrainChart(activeTrains.get(choice-1));
    }
}
