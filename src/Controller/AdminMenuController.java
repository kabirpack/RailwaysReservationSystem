package Controller;

import Model.Authentication;
import Model.ServicesManager;
import Model.UserAccount;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;
import View.ServiceManagerUI.ServiceManagerUI;

import java.text.ParseException;

public class AdminMenuController {
    RailwaysMenu menu = new RailwaysMenu();
    ServiceManagerUI smUI = new ServiceManagerUI();
    ServiceController serviceController = new ServiceController();
    UserMenuController userMenuController = new UserMenuController();
    Authentication auth = new Authentication();
    ServicesManager sm = new ServicesManager();

    public void adminMenuController(UserAccount user) throws ParseException {
        if(user.isAdmin()){
           int choice = menu.showRailwayMenu(MenuItems.adminMenu.class);
            switch (choice){
                case 1:{
                    choice = menu.showRailwayMenu(MenuItems.manageServiceMenu.class);

                    switch (choice){
                        case 1:{
                            smUI.addService(sm,serviceController);
                            this.adminMenuController(user);
                            return;
                        }
                        case 2:{
                            smUI.removeService(sm, serviceController);
                            this.adminMenuController(user);
                            return;
                        }
                        case 3: {
                            smUI.holdService(sm, serviceController);
                            this.adminMenuController(user);
                            return;
                        }
                        case 4: {
                            smUI.resumeService(sm, serviceController);
                            this.adminMenuController(user);
                            return;
                        }
                        case 5: {
                            sm.showAllServices();
                            this.adminMenuController(user);
                            return;
                        }
                        case 6:{
                            SessionController.logOut();
                            return;
                        }
                    }

                }
                case 2:{
                userMenuController.userMenuController();
                this.adminMenuController(user);
                return;
                }

                case 3:{
                   serviceController.prepareChart(sm);
                    this.adminMenuController(user);
                    return;
                }
                case 4:{
                    SessionController.logOut();
                }
            }

        }else{
            System.out.println("not a admin");
        }
    }
}
