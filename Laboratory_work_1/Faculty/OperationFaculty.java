package Laboratory_work_1.Faculty;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.Faculty.Faculty.*;
import static Laboratory_work_1.FileManagerOperations.FileManager.readStudent;
import static Laboratory_work_1.Student.Student.enrollstudent;

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
                d - display faculties
                df/<field> - display all faculties of a field

                b - Back""");

        String choice = "";
        Scanner inputScanner = new Scanner(System.in);
        while(!"b".equals(choice)){
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            String[] parts;
            try {
                 parts = choice.split("/");
                switch (parts[0]) {
                    case "nf" -> addFaculty(parts);
                    case "ss" -> identifyFaculty(parts);
                    case "d" -> Faculties();
                    case "df" -> allFacultiesField(parts);
                    case "b" -> {}
                    default -> System.out.println("You did not enter the correct data!!!");
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Attention, the data was not entered according to the requirements in the menu.");
                choice = "";
            }
            if(choice.equals("b")) {
                break;
            }
        }
    }
}
