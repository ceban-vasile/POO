package Laboratory_work_1;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.Faculty.*;
import static java.lang.System.exit;

public class Main {
    public static void tumMenu() throws ParseException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("""
                Welcome to TUM's student management system!
                What do you want to do?
                g - General operations
                f - Faculty operations
                s - Student operations
                
                q - Quit program
                """);
        System.out.print("your input>");
        String choice = myScanner.nextLine();
        if(choice.equals("g")){// generalOperations();
             }
        else if(choice.equals("f")){
            facultyOperations();
        }
        else if(choice.equals("q")){
                System.exit(0);
        }
        else{
            System.out.println("You did not enter the correct data!!!");
            tumMenu();
        }
    }
    public static void main(String[] args) throws ParseException {
        tumMenu();
    }
}
