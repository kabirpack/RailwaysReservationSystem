package View.RailwayMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RailwaysMenu<E extends Enum<E>>{

    boolean done;
    int choice;
    Scanner sc = new Scanner(System.in);

    public int showRailwayMenu(Class<E> menuData) {
        int index = 1;
        for (Enum<E> menuVal: menuData.getEnumConstants()) {
            System.out.println(Integer.toString(index++)+". "+menuVal.toString());
        }
        int menuItemCount = menuData.getEnumConstants().length;
        System.out.println("Enter your choice:");
         choice = 0;
        this.done = false;
        while(!this.done){
            try{
                choice = sc.nextInt();
                if(choice > menuItemCount){
                    throw new InputMismatchException("invalid");
                }else{
                    this.done = true;
                    return choice;
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter correct choice");
            }
        }
    return  choice;
    }

    public static void main(String[] args) {
        RailwaysMenu rm = new RailwaysMenu();
        System.out.println(rm.showRailwayMenu(MenuItems.userMenu.class));
        System.out.println(rm.showRailwayMenu(MenuItems.adminMenu.class));
    }

}
