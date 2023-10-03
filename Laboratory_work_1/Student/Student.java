package Laboratory_work_1.Student;

import Laboratory_work_1.Faculty.Faculty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static Laboratory_work_1.FileManagerOperations.FileManager.*;

public class Student extends Faculty {
    String firstName;
    String lastName;
    public String email;
    Date enrollmentDate, dateOfBirth;

    public Student(String abbreviation, String firstName, String lastName, String email, Date dateOfBirth, Date enrollmentDate) {
        super(abbreviation);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
    }

    public static ArrayList<Student> enrollstudent = new ArrayList<>();
    public static ArrayList<String> grad = new ArrayList<>();

    public static void facultyStudent(String[] parts) throws ParseException {

        String strDate = parts[5]+"/"+parts[6]+"/"+parts[7];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = dateFormat.parse(strDate);

        strDate = parts[8]+"/"+parts[9]+"/"+parts[10];
        Date enrollD = dateFormat.parse(strDate);
        Student createStudent = new Student(parts[1], parts[2], parts[3], parts[4], birthday, enrollD);
        writerNewStudent(createStudent);

    }
    public static void isGraduated(String[] parts) {
        enrollstudent.clear();
        readStudent();
        for (Student stud: enrollstudent) {
            if (stud.email.equals(parts[1])) {
                writerGraduatedStudent(stud.email);
            }
        }
    }
    public static void enrollStudentFaculty(String[] parts){
        enrollstudent.clear();
        readStudent();
        grad.clear();
        readGraduatedStudent();
        for(Student stud: enrollstudent){
            if(stud.abbreviation.equals(parts[1]) && !grad.contains(stud.email)){
                System.out.println("Faculty: "+stud.abbreviation+", "+"First Name: "+stud.firstName+", "+"Last Name: "+stud.lastName+", "+"Email: "+stud.email+", "+"Birthday: "+stud.dateOfBirth+", "+"Enrollment Date: "+stud.enrollmentDate);
            }
        }
    }
    public static void graduatedStudentFaculty(String[] parts){
        enrollstudent.clear();
        readStudent();
        grad.clear();
        readGraduatedStudent();
        for(Student stud: enrollstudent){
            if(stud.abbreviation.equals(parts[1]) && grad.contains(stud.email)) {
                System.out.println("Faculty: " + stud.abbreviation + ", " + "First Name: " + stud.firstName + ", " + "Last Name: " + stud.lastName + ", " + "Email: " + stud.email + ", " + "Birthday: " + stud.dateOfBirth + ", " + "Enrollment Date: " + stud.enrollmentDate);
            }
        }
    }
    public static void isStudentFaculty(String[] parts){
        enrollstudent.clear();
        readStudent();
        grad.clear();
        readGraduatedStudent();
        for(Student stud: enrollstudent){
            if(stud.abbreviation.equals(parts[1]) && stud.email.equals(parts[2])){
                if(grad.contains(parts[2])) {
                    System.out.println("NO");
                } else System.out.println("YES");
            }
        }
    }
    @Override
    public String toString() {
        return abbreviation+"/"+firstName+"/"+lastName+"/"+email+"/"+dateOfBirth+"/"+enrollmentDate;
    }
}
