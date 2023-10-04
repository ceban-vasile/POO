package Laboratory_work_1.Menu;

import Laboratory_work_1.StudentandFacultyOperations.FacultyOperations;
import Laboratory_work_1.StudentandFacultyOperations.StudentOperations;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    FacultyOperations faf = new FacultyOperations();
    StudentOperations stud = new StudentOperations();
    public Menu() throws ParseException {
        System.out.println("""
                Welcome to TUM's student management system!
                What do you want to do?
                g - General operations
                f - Faculty operations
                
                q - Quit program
                """);
        String choice = "";
        Scanner inputScanner = new Scanner(System.in);

        while(!choice.equals("q")){
            System.out.print("your input>");
            choice = inputScanner.next();
            switch (choice) {
                case "g" -> faf.menuFacultyOperations();
                case "f" -> stud.menuStudentFaculty();
                case "q" -> {}
                default ->  System.out.println("You did not enter the correct data!!!");
            }
        }
        inputScanner.close();
    }
}
