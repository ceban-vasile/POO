package Laboratory_work_1.Menu;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.Faculty.OperationFaculty.menuFacultyOperations;
import static Laboratory_work_1.Student.OperationStudent.menuStudentFaculty;

public class Menu {
    // different class application loop ex
    public static void tumMenu() throws ParseException {
        Scanner inputScanner = new Scanner(System.in);
        // close scanner
        System.out.println("""
                Welcome to TUM's student management system!
                What do you want to do?
                g - General operations
                f - Faculty operations
                s - Student operations
                
                q - Quit program
                """);
        String choice = "";

        // give meaningful condition
        while(!"q".equals(choice)){
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            switch (choice) {
                case "g" -> menuFacultyOperations();
                case "f" -> menuStudentFaculty();
                case "q" -> {}
                default ->  System.out.println("You did not enter the correct data!!!");
            }
        }
    }
}
