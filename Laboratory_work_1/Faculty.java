package Laboratory_work_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Faculty extends Student{
    String name;
    static String abbreviation;

    public Faculty(String abbreviation, String firstName, String lastName, String email, Date dateOfBirth) {
        super(firstName, lastName, email, dateOfBirth);
        this.abbreviation = abbreviation;
    }

    static ArrayList<Faculty> student = new ArrayList<>();
    static ArrayList<Faculty> graduated = new ArrayList<>();
    enum StudyField {
        MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE
    }
    public static void createStudent() throws ParseException {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Faculty abbreviation>");
        abbreviation = myScanner.next();
        System.out.print("First Name>");
        firstName = myScanner.next();
        System.out.print("Last Name>");
        lastName = myScanner.next();
        System.out.print("Email>");
        email = myScanner.next();
//        System.out.print("Enrollment Date>");
//        String enrollDate = myScanner.next();
//        Date enrolldate = new SimpleDateFormat("dd/MM/yyyy").parse(enrollDate);
//        enrollmentDate = enrolldate;
        System.out.println("Birthday>");
        String strDate = myScanner.next();
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        dateOfBirth = birthday;
        Faculty createStudent = new Faculty(abbreviation, firstName, lastName, email, dateOfBirth);
        student.add(createStudent);
    }
    public static void graduateStudent(String Email) {
        for (int i = 0; i < student.size(); i++) {
            Student stud = student.get(i);
            if (stud.email.equals(Email)) {
                graduated.add(student.get(i));
                student.remove(i);
                System.out.println("Student with email " + Email + " has graduated.");
                return;
            }
        }
        System.out.println("Student with email " + Email + " not found.");
    }
    public static void displayEnrollStud(String abbr){
        for(Faculty stud: student){
            if(abbreviation.equals(abbr)){
                System.out.println(stud);
            }
        }
    }
    public static void displayGradStud(String abbr){
        for(Student stud: graduated){
            if(abbreviation.equals(abbr)){
                System.out.println(stud);
            }
        }
    }
    public static void facultyOperations() throws ParseException {
        System.out.println("""
                Faculty operations
                What do you want to do?
                
                ns/<faculty abbreviation>/<firstName>/<LastName>/<email>/<day>/<month>/<year> - create student
                gs/<email> - (g)raduate (s)tudent
                ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents
                dg/<faculty abbreviation> - (d)isplay (g)raduated students
                bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                
                b - Back""");
        Scanner myScanner = new Scanner(System.in);
        String Email, abbr;
        while(true){
            System.out.print("your input>");
            String choice = myScanner.next();
            switch(choice){
                case "ns":
                    createStudent();
                    break;
                case "gs":
                    System.out.print("Email>");
                    Email = myScanner.next();
                    graduateStudent(Email);
                    break;
                case "ds":
                    System.out.print("Faculty abbreviation> ");
                    abbr = myScanner.next();
                    displayEnrollStud(abbr);
                    break;
                case "dg":
                    System.out.print("Faculty abbreviation> ");
                    abbr = myScanner.next();
                    displayGradStud(abbr);
                    break;
                case "bf":
                    System.out.print("Faculty abbreviation> ");
                    abbr = myScanner.next();
                    System.out.print("Email> ");
                    Email = myScanner.next();
                    break;
                case "b":
                    break;
                default:
                    System.out.println("You did not enter the correct data!!!");
            }
            if(choice.equals("b")) {
                break;
            }
        }
        Main.tumMenu();
    }
    @Override
    public String toString() {
        return "Faculty: "+abbreviation+", "+"First Name: "+firstName+", "+"Last Name: "+lastName+", "+"Email: "+email+", "+"Birthday: "+dateOfBirth;
    }

}
