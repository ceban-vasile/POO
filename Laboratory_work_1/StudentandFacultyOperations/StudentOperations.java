package Laboratory_work_1.StudentandFacultyOperations;

import Laboratory_work_1.FileManagerOperations.FileManager;
import Laboratory_work_1.Student.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Laboratory_work_1.Student.Student.enrollstudent;
import static Laboratory_work_1.Student.Student.grad;

public class StudentOperations {
    FileManager fileManager = new FileManager();
    public void menuStudentFaculty() throws ParseException {
        System.out.println("""
                Faculty operations
                What do you want to do?
                
                ns/<faculty abbreviation>/<firstName>/<LastName>/<email>/<day_enroll>/<month_enroll>/<year_enroll><day>/<month>/<year> - create student
                gs/<email> - (g)raduate (s)tudent
                ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents
                dg/<faculty abbreviation> - (d)isplay (g)raduated students
                bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                
                b - Back""");
        var inputScanner = new Scanner(System.in);
        String choice = "";
        while(!choice.equals("b")){
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            String[] parts = choice.split("/");

            switch (parts[0]) {
                case "ns" -> facultyStudent(parts);
                case "gs" -> isGraduated(parts);
                case "ds" -> enrollStudentFaculty(parts);
                case "dg" -> graduatedStudentFaculty(parts);
                case "bf" -> isStudentFaculty(parts);
                case "b" -> {}
                default -> System.out.println("You did not enter the correct data!!!");
            }
        }
    }
    private void facultyStudent(String[] parts) throws ParseException {
        if(parts.length == 11) {
            String strDate = parts[5] + "/" + parts[6] + "/" + parts[7];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthday = dateFormat.parse(strDate);

            strDate = parts[8] + "/" + parts[9] + "/" + parts[10];
            Date enrollD = dateFormat.parse(strDate);
            Student createStudent = new Student(parts[1], parts[2], parts[3], parts[4], birthday, enrollD);
            fileManager.writerNewStudent(createStudent);
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
    private void isGraduated(String[] parts) {
        if(parts.length == 2) {
            enrollstudent.clear();
            fileManager.readStudent();
            for (Student stud : enrollstudent) {
                if (stud.email.equals(parts[1])) {
                    fileManager.writerGraduatedStudent(stud.email);
                    return;
                }
            }
            System.out.println("Can’t graduate student: " + parts[1] + " (student not present)");
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
    private void enrollStudentFaculty(String[] parts){
        if(parts.length == 2) {
            enrollstudent.clear();
            fileManager.readStudent();
            grad.clear();
            fileManager.readGraduatedStudent();
            for (Student stud : enrollstudent) {
                if (stud.abbreviation.equals(parts[1]) && !grad.contains(stud.email)) {
                    System.out.println("Faculty: " + stud.abbreviation + ", " + "First Name: " + stud.firstName + ", " + "Last Name: " + stud.lastName + ", " + "Email: " + stud.email + ", " + "Birthday: " + stud.dateOfBirth + ", " + "Enrollment Date: " + stud.enrollmentDate);
                    return;
                }
            }
            System.out.println("No students found at the " + parts[1] + " faculty.");
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }

    private void graduatedStudentFaculty(String[] parts){
        if(parts.length == 2) {
            enrollstudent.clear();
            fileManager.readStudent();
            grad.clear();
            fileManager.readGraduatedStudent();
            for (Student stud : enrollstudent) {
                if (stud.abbreviation.equals(parts[1]) && grad.contains(stud.email)) {
                    System.out.println("Faculty: " + stud.abbreviation + ", " + "First Name: " + stud.firstName + ", " + "Last Name: " + stud.lastName + ", " + "Email: " + stud.email + ", " + "Birthday: " + stud.dateOfBirth + ", " + "Enrollment Date: " + stud.enrollmentDate);
                    return;
                }
            }
            System.out.println("No graduate students were found at the " + parts[1] + " faculty.");
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
    private void isStudentFaculty(String[] parts){
        if(parts.length == 3) {
            enrollstudent.clear();
            fileManager.readStudent();
            grad.clear();
            fileManager.readGraduatedStudent();
            for (Student stud : enrollstudent) {
                if (stud.abbreviation.equals(parts[1]) && stud.email.equals(parts[2])) {
                    if (grad.contains(parts[2])) {
                        System.out.println("NO");
                    } else System.out.println("YES");
                }
            }
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
}
