package Laboratory_work_1.Student;

import Laboratory_work_1.Faculty.Faculty;
import java.util.ArrayList;
import java.util.Date;

public class Student extends Faculty {
    public String firstName;
    public String lastName;
    public String email;
    public Date enrollmentDate;
    public Date dateOfBirth;

    public Student(){}
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
    @Override
    public String toString() {
        return abbreviation+"/"+firstName+"/"+lastName+"/"+email+"/"+dateOfBirth+"/"+enrollmentDate;
    }
}
