package Model;

import java.util.ArrayList;

public class UserAccount {
    private String userName;
    private String password;
    private boolean isAdmin;
    private ArrayList<Ticket> myTickets = new ArrayList<>();

    public UserAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin() {
        this.isAdmin = true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public ArrayList<Ticket> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(ArrayList<Ticket> myTickets) {
        for(Ticket ticket : myTickets){
            this.myTickets.add(ticket);
        }
    }

    public void removeTickets(int index){
        myTickets.remove(index);
    }

}
