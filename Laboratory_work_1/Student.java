package Laboratory_work_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Laboratory_work_1.FileManager.writerStudent;

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
    static ArrayList<Student> enrollstudent = new ArrayList<>();
    static Scanner inputScanner = new Scanner(System.in);
    public static void facultyStudent() throws ParseException {

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


        Student createStudent = new Student(abbr, fName, lName, Email, enrol, birthday, enrollD);
        writerStudent(createStudent);
        enrollstudent.add(createStudent);

    }
    public static void isGraduated() {
        System.out.print("Email>");
        String Email = inputScanner.next();
        for (Student stud: enrollstudent) {
            if (stud.email.equals(Email)) {
                if(stud.enroll.equals("YES")) stud.enroll = "NO";
                else System.out.println("Student with email "+ Email +" is already graduated.");
                return;
            }
        }
        System.out.println("Student with email " + Email + " not found.");
    }
    public static void enrollStudentFaculty(){
        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();
        for(Student stud: enrollstudent){
            if(stud.abbreviation.equals(abbr) && stud.enroll.equals("YES")){
                System.out.println("Faculty: "+stud.abbreviation+", "+"First Name: "+stud.firstName+", "+"Last Name: "+stud.lastName+", "+"Email: "+stud.email+", "+"Enrollment: "+stud.enroll+", "+"Birthday: "+stud.dateOfBirth+", "+"Enrollment Date: "+stud.enrollmentDate);
            }
        }
    }
    public static void graduatedStudentFaculty(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Faculty abbreviation>");
        String abbr = myScanner.next();
        for(Student stud: enrollstudent){
            if(stud.abbreviation.equals(abbr) && stud.enroll.equals("NO")){
                System.out.println("Faculty: "+stud.abbreviation+", "+"First Name: "+stud.firstName+", "+"Last Name: "+stud.lastName+", "+"Email: "+stud.email+", "+"Enrollment: "+stud.enroll+", "+"Birthday: "+stud.dateOfBirth+", "+"Enrollment Date: "+stud.enrollmentDate);
            }
        }
    }
    public static void isStudentFaculty(){
        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();
        System.out.print("Email>");
        String Email = inputScanner.next();
        for(Student stud: enrollstudent){
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
        return "\n"+abbreviation+" "+firstName+" "+lastName+" "+email+" "+enroll+" "+dateOfBirth+" "+enrollmentDate;
    }
}
