package Laboratory_work_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Laboratory_work_1.Student.enrollstud;

public class FileManager {

    public static void readStudent(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\enrollmentStudents.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Student student = getStudent(line);
                enrollstud.add(student);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    private static Student getStudent(String line) throws ParseException {
        String[] parts = line.split(",");

        String abbreviation = parts[0];
        String firstName = parts[1];
        String lastName = parts[2];
        String email = parts[3];
        String enrol = parts[4];
        String enrollDate = parts[5];
        String birthdayString = parts[6];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateEnroll = dateFormat.parse(enrollDate);
        Date dateOfBirth = dateFormat.parse(birthdayString);

        Student student = new Student(abbreviation, firstName, lastName, email, enrol, dateEnroll, dateOfBirth);
        return student;
    }
}
