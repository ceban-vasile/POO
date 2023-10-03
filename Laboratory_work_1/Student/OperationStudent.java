package Laboratory_work_1.Student;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.Student.Student.*;

public class OperationStudent {
    public static void menuStudentFaculty() throws ParseException {
        // move to faculty

        System.out.println("""
                Faculty operations
                What do you want to do?
                
                ns/<faculty abbreviation>/<firstName>/<LastName>/<email>/<day_enroll>/<month_enroll>/<year_enroll><day>/<month>/<year> - create student
                gs/<email> - (g)raduate (s)tudent
                ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents
                dg/<faculty abbreviation> - (d)isplay (g)raduated students
                bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                
                b - Back""");
        var inputScanner = new Scanner(System.in);
        String choice = "";
        while("b" != choice){
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            String[] parts;
            try{
                parts = choice.split("/");
                switch (parts[0]) {
                    case "ns" -> facultyStudent(parts);
                    case "gs" -> isGraduated(parts);
                    case "ds" -> enrollStudentFaculty(parts);
                    case "dg" -> graduatedStudentFaculty(parts);
                    case "bf" -> isStudentFaculty(parts);
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
