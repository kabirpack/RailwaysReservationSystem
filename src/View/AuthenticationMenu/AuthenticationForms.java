package View.AuthenticationMenu;

import Controller.Session.SessionController;
import Controller.Authentication.Authentication;
import Utilities.RailwayUtility;
import Model.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AuthenticationForms implements IAuthenticationUI {
    ArrayList<String> credentials = new ArrayList<>();
    boolean done;
    RailwayUtility utility = new RailwayUtility();
    Authentication auth = new Authentication();

    @Override
    public ArrayList<String> registrationForm() {
        this.done = false;
        while (!done) {
            try {
                System.out.println("-----------------\nUSER REGISTRATION FORM\n-----------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter username");
                String userName = utility.getStringInput();
                if (userName.length() > 4) {
                    if (auth.validateUserName(userName)) {
                        System.out.println("Username Already Exists");
                        throw new InputMismatchException();
                    }
                } else {
                    System.out.println("Username is too short");
                    throw new InputMismatchException();
                }
                System.out.println("Enter password");
                String passWord = utility.getStringInput();
                credentials.add(userName);
                credentials.add(passWord);
                this.done = true;
            } catch (InputMismatchException e) {
                System.out.println("invalid, Enter again");
            }
        }
        return credentials;
    }

    @Override
    public UserAccount loginForm() throws ParseException {
        this.done = false;
        while (!done) {
            try {
                System.out.println("-----------------\nUSER LOGIN FORM\n-----------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter username");
                String userName = utility.getStringInput();
                if (auth.validateUserName(userName) == false) {
                    System.out.println("Username not found");
                    throw new InputMismatchException();
                }
                System.out.println("Enter password");
                String passWord = utility.getStringInput();
                if (!auth.validateCredential(userName,passWord)) {
                    System.out.println("Wrong Password");
                    throw new InputMismatchException();
                }else {
                    UserAccount user = auth.getUserAccount(userName, passWord);
                    this.done = true;
                    return user;
                }
            } catch (InputMismatchException e) {
                SessionController.logOut();
            }
        }
        return null;
    }
}