package Laboratory_work_1.Faculty;

import Laboratory_work_1.Student.Student;

import java.util.ArrayList;

import static Laboratory_work_1.FileManagerOperations.FileManager.addNewFaculty;
import static Laboratory_work_1.FileManagerOperations.FileManager.readFaculty;
import static Laboratory_work_1.Student.Student.enrollstudent;

public class Faculty{
    String name;
    public String abbreviation;
    StudyField field;
    public Faculty(String abbreviation){ this.abbreviation = abbreviation;}
    public Faculty(String name, String abbreviation, StudyField field){
        this.name = name;
        this.abbreviation = abbreviation;
        this.field = field;
    }
    public static ArrayList<Faculty> faculty = new ArrayList<>();

    public static void addFaculty(String[] parts){
        Faculty createFaculty = new Faculty(parts[1], parts[2],StudyField.valueOf(parts[3]));
        addNewFaculty(createFaculty);
    }
    public static void identifyFaculty(String[] parts){
        faculty.clear();
        readFaculty();
        for(Student stud: enrollstudent){
            if(stud.email.equals(parts[1])){
                for(Faculty faf: faculty){
                    if(stud.abbreviation.equals(faf.abbreviation)){
                        System.out.println("Faculty name: "+faf.name+", "+"Abbreviation: "+faf.abbreviation+", "+"Study field: "+faf.field);
                    }
                }
            }
        }
    }
    public static void Faculties(){
        faculty.clear();
        readFaculty();
        for(Faculty f: faculty){
            System.out.println("Faculty name: "+f.name+", "+"Abbreviation: "+f.abbreviation+", "+"Study Field: "+f.field);
        }
    }
    public static void allFacultiesField(String[] parts){
        faculty.clear();
        readFaculty();
        for(Faculty f: faculty){
            if(f.field.equals(StudyField.valueOf(parts[1]))) System.out.println("Faculty name: "+f.name+", "+"Abbreviation: "+f.abbreviation+", "+"Study Field: "+f.field);
        }
    }
    @Override
    public String toString(){
        return name+"/"+abbreviation+"/"+field;
    }
}
