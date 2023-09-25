package Laboratory_work_1;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Student {
     static String firstName;
    static String lastName;
    static String email;
    static Date enrollmentDate;
    static Date dateOfBirth;

    public Student(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
