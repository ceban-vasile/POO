package Laboratory_work_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Faculty extends Student{
    String name;
    String abbreviation;
    public Faculty(){}

    public Faculty(String firstName, String lastName, String email, Date dateOfBirth, String abbreviation) {
        super(firstName, lastName, email, dateOfBirth);
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    static List<Faculty> enrollstud = new ArrayList<>();
    enum StudyField {
        MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE
    }
    public static void createStudent() throws ParseException {
        Scanner myScanner = new Scanner(System.in);

        Faculty createStudent = new Faculty();

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

        Student student = new Student();
        student.setFaculty(createStudent);
        enrollstud.add(createStudent);

    }
    public static void graduateStudent(String Email) {
        for (int i = 0; i < enrollstud.size(); i++) {
            Student stud = enrollstud.get(i);
            if (stud.email.equals(Email)) {
                stud.setEmail(null);//graduated.add(enrollstud.get(i));
                //enrollstud.remove(i);
                System.out.println("Student with email " + Email + " has graduated.");
                return;
            }
        }
        System.out.println("Student with email " + Email + " not found.");
    }
    public static void displayEnrollStud(String abbr){
        for(Faculty stud: enrollstud){
            if(stud.abbreviation.equals(abbr) && stud.email != null){
                System.out.println(stud);
            }
        }
    }
    public static void displayGradStud(String abbr){
        for(Faculty stud: enrollstud){
            if(stud.abbreviation.equals(abbr) && stud.email == null){
                System.out.println(stud);
            }
        }
    }
    public static void isStudentFaculty(String abbr, String Email){
        for(Faculty stud: enrollstud){
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
