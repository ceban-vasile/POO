package Laboratory_work_1;

import java.util.ArrayList;
import java.util.Scanner;

import static Laboratory_work_1.Student.enrollstudent;


public class Faculty{
    String name;
    String abbreviation;
    public Faculty(String abbreviation){ this.abbreviation = abbreviation;}
    public Faculty(String name, String abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }
    static ArrayList<Faculty> faculty = new ArrayList<>();
    static Scanner inputScanner = new Scanner(System.in);

    public static void createFaculty(){

        System.out.print("Faculty name>");
        String faf = inputScanner.next();

        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();

        Faculty createFaculty = new Faculty(faf, abbr);

        faculty.add(createFaculty);
    }
    public static void identifyFaculty(){
        System.out.print("Email>");
        String Email = inputScanner.next();
        for(Student stud: enrollstudent){
            if(stud.email.equals(Email)){
                for(Faculty faf: faculty){
                    if(stud.abbreviation.equals(faf.abbreviation)){
                        System.out.println("Faculty name: "+faf.name+", "+"Abbreviation: "+faf.abbreviation);
                    }
                }
            }
        }
    }
    public static void Faculties(){
        for(Faculty f: faculty){
            System.out.println("Faculty name: "+f.name+", "+"Abbreviation: "+f.abbreviation);
        }
    }
    @Override
    public String toString(){
        return name+" "+abbreviation;
    }
}
