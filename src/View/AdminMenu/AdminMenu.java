package View.AdminMenu;

import Controller.Session.SessionController;
import View.UserMenu.UserMenu;
import Controller.ServiceController.ServicesManager;
import Model.UserAccount;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;
import View.ServiceManagerUI.ServiceManagerUI;

import java.text.ParseException;

public class AdminMenu {
    RailwaysMenu menu = new RailwaysMenu();
    ServiceManagerUI smUI = new ServiceManagerUI();
    UserMenu userMenuController = new UserMenu();
    ServicesManager sm = new ServicesManager();

    public void adminMenuController(UserAccount user) throws ParseException {
        if(user.isAdmin()){
           int choice = menu.showRailwayMenu(MenuItems.adminMenu.class);
            switch (choice){
                case 1:{
                    choice = menu.showRailwayMenu(MenuItems.manageServiceMenu.class);

                    switch (choice){
                        case 1:{
                            smUI.addService();
                            this.adminMenuController(user);
                            return;
                        }
                        case 2:{
                            smUI.removeService();
                            this.adminMenuController(user);
                            return;
                        }
                        case 3: {
                            smUI.holdService();
                            this.adminMenuController(user);
                            return;
                        }
                        case 4: {
                            smUI.resumeService();
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
                   sm.prepareChart();
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
