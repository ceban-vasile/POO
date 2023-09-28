package Laboratory_work_1;

import java.text.ParseException;
import java.util.Scanner;

import static Laboratory_work_1.FileManager.readStudent;
import static Laboratory_work_1.Student.*;

public class OperationStudent {
    public static void menuStudentFaculty() throws ParseException {
        // move to faculty
        enrollstudent.clear();
        readStudent();
        System.out.println("""
                Faculty operations
                What do you want to do?
                
                ns/<faculty abbreviation>/<firstName>/<LastName>/<email>/<day>/<month>/<year> - create student
                gs/<email> - (g)raduate (s)tudent
                ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents
                dg/<faculty abbreviation> - (d)isplay (g)raduated students
                bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                
                b - Back""");
        var inputScanner = new Scanner(System.in);
        String choice = "";
        while(!"q".equals(choice)){
            System.out.print("your input>");
            choice = inputScanner.next();
            switch (choice) {
                case "ns/" -> facultyStudent();
                case "gs/" -> isGraduated();
                case "ds/" -> enrollStudentFaculty();
                case "dg/" -> graduatedStudentFaculty();
                case "bf/" -> isStudentFaculty();
                case "b" -> {}
                default -> System.out.println("You did not enter the correct data!!!");
            }
            if(choice.equals("b")) {
                break;
            }
        }
    }
}
