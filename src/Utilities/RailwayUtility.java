package Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RailwayUtility {
    public String generatePnrNumber(){
        return "PNR" +(long) Math.floor(Math.random() * 9_000_000_000L);
    }

    public String getCurrentDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String day = dayOfWeek.toString().toUpperCase(Locale.ROOT);
        return day;
    }
    public String cmdPrompt(String msg){
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine().toUpperCase(Locale.ROOT);
        return userChoice;
    }

        public String getCurrentTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String strTime = dateFormat.format(date);
        return strTime;
    }


    public String getStringInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getIntInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String getDayByDate(String date) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        return format2.format(dt1).toUpperCase(Locale.ROOT);
    }


    public String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getNextDay(){
        DayOfWeek dayOfWeek = LocalDate.now().plusDays(1).getDayOfWeek();
        String day = dayOfWeek.toString().toUpperCase(Locale.ROOT);
        return day;
    }

    public String getNextDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        return dtf.format(now);
    }

    public ArrayList<String> generateSeats(int count){
        ArrayList<String> seatList = new ArrayList<>();
        for(int i=1;i<= count ; i++){
            seatList.add(Integer.toString(i));
        }
        return seatList;
    }

    public boolean isTimeFormatMatches(String time){
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(time);
        return m.matches();
    }

    public boolean isDateFormatMatches(String date){
        return false;
    }
}
