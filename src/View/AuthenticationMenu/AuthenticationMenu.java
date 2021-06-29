package View.AuthenticationMenu;

import View.AdminMenu.AdminMenu;
import Controller.Session.SessionController;
import View.UserMenu.UserMenu;
import Controller.Authentication.Authentication;
import Model.UserAccount;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;

import java.text.ParseException;
import java.util.ArrayList;

public class AuthenticationMenu {
    private RailwaysMenu menu = new RailwaysMenu();
    private AuthenticationForms authForms = new AuthenticationForms();
    private AdminMenu adminMenu = new AdminMenu();
    private UserMenu userMenu = new UserMenu();


    public void authenticationMenu() throws ParseException {
        ArrayList<String> credential;
        int choice = menu.showRailwayMenu(MenuItems.landingMenu.class);

        switch (choice){
            case 1:{
                credential = authForms.registrationForm();
                if(credential.size() >0){
                    UserAccount user = new UserAccount(credential.get(0),credential.get(1));
                    Authentication auth = new Authentication();
                    auth.register(user);
                }else{
                    System.out.println("Registration failed");
                    menu.showRailwayMenu(MenuItems.landingMenu.class);
                }
            }
            case 2:{
                UserAccount user = authForms.loginForm();
                SessionController session = new SessionController();
                session.setUser(user);
                if(user.isAdmin()){
                    adminMenu.adminMenuController(user);
                }
                else if(!user.isAdmin()){
                    userMenu.userMenuController();
                }
                return;
            }
        }
    }


}
