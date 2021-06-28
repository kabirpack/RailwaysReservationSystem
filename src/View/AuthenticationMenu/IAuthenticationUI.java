package View.AuthenticationMenu;

import Model.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;

public interface IAuthenticationUI {

    ArrayList<String> registrationForm();
    UserAccount loginForm() throws ParseException;
}
