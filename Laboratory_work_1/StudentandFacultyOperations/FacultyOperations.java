package Laboratory_work_1.StudentandFacultyOperations;

import Laboratory_work_1.Faculty.Faculty;
import Laboratory_work_1.Faculty.StudyField;
import Laboratory_work_1.FileManagerOperations.FileManager;
import Laboratory_work_1.Student.Student;

import java.util.Scanner;

import static Laboratory_work_1.Faculty.Faculty.faculty;

public class FacultyOperations {
    FileManager fileManager = new FileManager();
    public void menuFacultyOperations() {
        System.out.println("""
                General operations
                What do you want to do?

                nf/<faculty name>/<faculty abbreviation>/<field> - create faculty
                ss/<student email> - search student and show faculty
                d - display faculties
                df/<field> - display all faculties of a field

                b - Back""");

        String choice = "";
        Scanner inputScanner = new Scanner(System.in);
        while (!choice.equals("b")) {
            System.out.print("your input>");
            choice = inputScanner.nextLine();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "nf" -> addFaculty(parts);
                case "ss" -> searchFaculty(parts);
                case "d" -> displayFaculties();
                case "df" -> allFacultiesField(parts);
                case "b" -> {}
                default -> System.out.println("You did not enter the correct data!!!");
            }
        }
        inputScanner.close();
    }
    private void addFaculty(String[] parts){
        if(parts.length == 4){
            try {
                Faculty createFaculty = new Faculty(parts[1], parts[2], StudyField.valueOf(parts[3]));
                fileManager.addNewFaculty(createFaculty);
            }catch(IllegalArgumentException e){
                System.out.println("You have not entered the study field correctly!!!");
            }
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
    private void searchFaculty(String[] parts){
        if(parts.length == 2){
            faculty.clear();
            fileManager.readFaculty();
            for (Student stud : Student.enrollstudent) {
                if (stud.email.equals(parts[1])) {
                    for (Faculty faf : faculty) {
                        if (stud.abbreviation.equals(faf.abbreviation)) {
                            System.out.println("Faculty name: " + faf.name + ", " + "Abbreviation: " + faf.abbreviation + ", " + "Study field: " + faf.field);
                        }
                    }
                    return;
                }
            }
            System.out.println("Can’t find the student: " + parts[1] + " (student not present");
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
    private void displayFaculties(){
        faculty.clear();
        fileManager.readFaculty();
        if(faculty.isEmpty()) {
            for (Faculty f : faculty) {
                System.out.println("Faculty name: " + f.name + ", " + "Abbreviation: " + f.abbreviation + ", " + "Study Field: " + f.field);
            }
        }else System.out.println("No faculty in the file was added.");
    }
    private void allFacultiesField(String[] parts){
        if(parts.length == 2) {
            faculty.clear();
            fileManager.readFaculty();
            for (Faculty f : faculty) {
                if (f.field.equals(StudyField.valueOf(parts[1]))){
                    System.out.println("Faculty name: " + f.name + ", " + "Abbreviation: " + f.abbreviation + ", " + "Study Field: " + f.field);
                    return;
                }
            }
            System.out.println("Study Field " + StudyField.valueOf(parts[1]) + " is not found.");
        }else System.out.println("You did not enter the correct data according the requirements to the menu.");
    }
}
