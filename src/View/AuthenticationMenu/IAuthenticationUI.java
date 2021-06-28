package View.AuthenticationMenu;

import Model.Authentication;
import Model.ServicesManager;
import Model.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;

public interface IAuthenticationUI {

    ArrayList<String> registrationForm(Authentication auth);
    UserAccount loginForm(Authentication auth, ServicesManager sm) throws ParseException;
}
