package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class UserAccount {
    private HashMap<String, String> credentials = new HashMap<>();
    private boolean isAdmin;
    private ArrayList<Ticket> myTickets = new ArrayList<>();

    public UserAccount(String userName, String password) {
        credentials.put(userName,password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin() {
        this.isAdmin = true;
    }

    public String getUserName() {
        for(String i : credentials.keySet()){
            return i;
        }
        return "";
    }

    public String getPassword(String userName){
        return credentials.get(userName);
    }

    public String getSessionTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String strTime = dateFormat.format(date);
        return strTime;
    }

    public String getSessionDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String day = dayOfWeek.toString().toUpperCase(Locale.ROOT);
        return day;
    }

    public HashMap<String, String> getCredentials() {
        return credentials;
    }

        public ArrayList<Ticket> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(ArrayList<Ticket> myTickets) {
        for(Ticket ticket : myTickets){
            this.myTickets.add(ticket);
        }
//        this.myTickets = myTickets;
    }

    public void removeTickets(int index){
        myTickets.remove(index);
    }


}
