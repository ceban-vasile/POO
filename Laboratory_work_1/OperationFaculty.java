package Laboratory_work_1;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.Faculty.*;
import static Laboratory_work_1.FileManager.readStudent;
import static Laboratory_work_1.Student.enrollstudent;

public class OperationFaculty {
    public static void menuFacultyOperations() throws ParseException {
        // move to a different class
        enrollstudent.clear();
        readStudent();
        System.out.println("""
                General operations
                What do you want to do?

                nf/<faculty name>/<faculty abbreviation>/<field> - create faculty
                ss/<student email> - search student and show faculty
                df - display faculties
                df/<field> - display all faculties of a field

                b - Back""");

        String choice = "";
        Scanner inputScanner = new Scanner(System.in);
        while(!"q".equals(choice)){
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            switch (choice) {
                case "nf/" -> createFaculty();
                case "ss/" -> identifyFaculty();
                case "df" -> Faculties();
                case "df/" -> {}
                case "q" -> {}
                default -> System.out.println("You did not enter the correct data!!!");
            }
            if(choice.equals("b")) {
                break;
            }
        }
    }
}
