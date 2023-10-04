package Laboratory_work_1.FileManagerOperations;

import Laboratory_work_1.Faculty.Faculty;
import Laboratory_work_1.Faculty.StudyField;
import Laboratory_work_1.Student.Student;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static Laboratory_work_1.Faculty.Faculty.faculty;
import static Laboratory_work_1.Student.Student.enrollstudent;
import static Laboratory_work_1.Student.Student.grad;

public class FileManager {

    public void writerNewStudent(Student student){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\enrollmentStudents.txt", true))) {
            bufferedWriter.write(String.valueOf(student));
            bufferedWriter.newLine();
        } catch (IOException e) {}
    }
    public void writerGraduatedStudent(String graduated){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\graduated.txt", true))) {
            bufferedWriter.write(graduated);
            bufferedWriter.newLine();
        } catch (IOException e) {}
    }
    public void readStudent(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\enrollmentStudents.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Student student = getStudent(line);
                enrollstudent.add(student);
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
    public void readGraduatedStudent(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\graduated.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                grad.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
    private Student getStudent(String line) throws ParseException {
        String[] parts = line.split("/");
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        return new Student(parts[0], parts[1], parts[2], parts[3], sdf.parse(parts[4]), sdf.parse(parts[5]));
    }
    //========================================================================================================
    public void addNewFaculty(Faculty faculty){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\faculty.txt", true))) {
            bufferedWriter.write(String.valueOf(faculty));
            bufferedWriter.newLine();
        } catch (IOException e) {}
    }
    public void readFaculty(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Vasile\\IdeaProjects\\POO\\Laboratory_work_1\\Files\\faculty.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Faculty faf = getFaculty(line);
                faculty.add(faf);
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
    private Faculty getFaculty(String line) throws ParseException {
        String[] parts = line.split("/");
        return new Faculty(parts[0], parts[1], StudyField.valueOf(parts[2]));
    }
}
