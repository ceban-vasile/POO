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
    Date enrollmentDate, dateOfBirth;
    public Student(){}

    public Student(String abbreviation, String firstName, String lastName, String email, Date dateOfBirth) {
        super(abbreviation);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    static ArrayList<Student> enrollstud = new ArrayList<>();
    static ArrayList<Student> graduated = new ArrayList<>();

    public static void createStudent() throws ParseException {
        Scanner myScanner = new Scanner(System.in);

        Student createStudent = new Student();

        System.out.print("Faculty abbreviation>");
        createStudent.setAbbreviation(myScanner.next());

        System.out.print("First Name>");
        createStudent.setFirstName(myScanner.next());

        System.out.print("Last Name>");
        createStudent.setLastName(myScanner.next());

        System.out.print("Email>");
        createStudent.setEmail(myScanner.next());

        System.out.println("Birthday>");
        String strDate = myScanner.next();
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        createStudent.setDateOfBirth(birthday);

        enrollstud.add(createStudent);

    }
    public static void graduateStudent(String Email) {
        for (int i = 0; i < enrollstud.size(); i++) {
            Student stud = enrollstud.get(i);
            if (stud.email.equals(Email)) {
                graduated.add(enrollstud.get(i));
                enrollstud.remove(i);
                System.out.println("Student with email " + Email + " has graduated.");
                return;
            }
        }
        System.out.println("Student with email " + Email + " not found.");
    }
    public static void displayEnrollStud(String abbr){
        for(Student stud: enrollstud){
            if(stud.abbreviation.equals(abbr)){
                System.out.println(stud);
            }
        }
    }
    public static void displayGradStud(String abbr){
        for(Student stud: graduated){
            if(stud.abbreviation.equals(abbr)){
                System.out.println(stud);
            }
        }
    }
    public static void isStudentFaculty(String abbr, String Email){
        for(Student stud: enrollstud){
            if(stud.abbreviation.equals(abbr) && stud.email.equals(Email)){
                System.out.println("This student belong to Faculty "+ stud.abbreviation);
            }
            else{
                System.out.println("This student doesn't belong to Faculty "+ stud.abbreviation);
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
                    isStudentFaculty(abbr, Email);
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
