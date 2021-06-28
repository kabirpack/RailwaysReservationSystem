package Controller;

import Model.Authentication;
import Model.ServicesManager;
import Model.UserAccount;
import View.AuthenticationMenu.AuthenticationUI;
import View.RailwayMenu.MenuItems;
import View.RailwayMenu.RailwaysMenu;

import java.text.ParseException;
import java.util.ArrayList;

public class AuthenticationController {
    private RailwaysMenu menu = new RailwaysMenu();
    private AuthenticationUI authView = new AuthenticationUI();
    private AdminMenuController adminMenu = new AdminMenuController();
    private UserMenuController userMenu = new UserMenuController();
    private static Authentication authSession;



    public static Authentication getAuthSession() {
        return authSession;
    }

    public void setAuthSession(Authentication authSession) {
        this.authSession = authSession;
    }

    public void authenticationController(Authentication auth, ServicesManager sm) throws ParseException {
        ArrayList<String> credential;
        int choice = menu.showRailwayMenu(MenuItems.landingMenu.class);

        switch (choice){
            case 1:{
                credential = authView.registrationForm(auth);
                if(credential.size() >0){
                    UserAccount user = new UserAccount(credential.get(0),credential.get(1));
                    auth.register(user);
                }else{
                    System.out.println("Registration failed");
                    menu.showRailwayMenu(MenuItems.landingMenu.class);
                }
            }
            case 2:{
                UserAccount user = authView.loginForm(auth, sm);
                SessionController session = new SessionController();
                session.setUser(user);
                if(user.isAdmin()){
                    adminMenu.adminMenuController(user, auth, sm);
                }
                else if(!user.isAdmin()){
                    userMenu.userMenuController(auth, sm);
                }
                return;
            }
        }
    }


}
