package Laboratory_work_1;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Student {
    static String firstName;
    static String lastName;
    String email;
    Date enrollmentDate, dateOfBirth;
    public Student(){}

    public Student(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    private Faculty faculty;


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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public static void generalOperations() throws ParseException {
        System.out.println("""
                General operations
                What do you want to do?
                
                nf/<faculty name>/<faculty abbreviation>/<field> - create faculty
                ss/<student email> - search student and show faculty
                df - display faculties
                df/<field> - display all faculties of a field
                
                b - Back""");

        Scanner myScanner = new Scanner(System.in);
        while(true){
            String choice = myScanner.nextLine();
            switch(choice){
                case "nf/":
                    break;
                case "ss":
                    break;
                case "df":

                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("You did not enter the correct data!!!");

            }
        }
    }
}
