package Laboratory_work_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student extends Faculty{
    String firstName;
    String lastName;
    String email;
    String enroll;
    Date enrollmentDate, dateOfBirth;

    public Student(String abbreviation, String firstName, String lastName, String email, String enroll, Date dateOfBirth, Date enrollmentDate) {
        super(abbreviation);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enroll = enroll;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
    }
    static ArrayList<Student> enrollstud = new ArrayList<>();

    public static void facultyStudent() throws ParseException {
        // TODO use constrcutors
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();

        System.out.print("First Name>");
        String fName = inputScanner.next();

        System.out.print("Last Name>");
        String lName = inputScanner.next();

        System.out.print("Email>");
        String Email = inputScanner.next();

        System.out.print("Enrollment>");
        String enrol = inputScanner.next();

        System.out.println("Birthday>");
        String strDate = inputScanner.next();
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

        System.out.println("Enrollment Date>");
        strDate = inputScanner.next();
        Date enrollD = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

        inputScanner.close();

        Student createStudent = new Student(abbr, fName, lName, Email, enrol, birthday, enrollD);
        enrollstud.add(createStudent);

    }
    public static void isGraduated() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Email>");
        String Email = inputScanner.next();
        inputScanner.close();
        for (Student stud: enrollstud) {
            if (stud.email.equals(Email)) {
                if(stud.enroll.equals("YES")) stud.enroll = "NO";
                else System.out.println("Student with email "+ Email +" is already graduated.");
                return;
            }
        }
        System.out.println("Student with email " + Email + " not found.");
    }
    public static void enrollStudentFaculty(){
        // TODO move functionality to Faclulty class
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();
        inputScanner.close();
        for(Student stud: enrollstud){
            if(stud.abbreviation.equals(abbr)){
                if(stud.enroll.equals("YES")) System.out.println(stud);
            }
        }
    }
    public static void graduatedStudentFaculty(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Faculty abbreviation>");
        String abbr = myScanner.next();
        for(Student stud: enrollstud){
            if(stud.abbreviation.equals(abbr)){
                if(stud.enroll.equals("NO")) System.out.println(stud);
            }
        }
    }
    public static void isStudentFaculty(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Faculty abbreviation>");
        String abbr = myScanner.next();
        System.out.print("Email>");
        String Email = myScanner.next();
        for(Student stud: enrollstud){
            if(stud.abbreviation.equals(abbr) && stud.email.equals(Email) && stud.enroll.equals("YES")){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    @Override
    public String toString() {
        return "Faculty: "+abbreviation+", "+"First Name: "+firstName+", "+"Last Name: "+lastName+", "+"Email: "+email+", "+"Enrollment: "+enroll+", "+"Birthday: "+dateOfBirth+", "+"Enrollment Date: "+enrollmentDate;
    }
}
