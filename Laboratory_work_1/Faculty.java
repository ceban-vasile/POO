package Laboratory_work_1;

import java.util.ArrayList;
import java.util.Scanner;

import static Laboratory_work_1.Student.enrollstud;


public class Faculty{
    String name;
    String abbreviation;
    public Faculty(String abbreviation){ this.abbreviation = abbreviation;}
    public Faculty(String name, String abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }
    static ArrayList<Faculty> faculty = new ArrayList<>();

    public static void createFaculty(){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Faculty name>");
        String faf = inputScanner.next();

        System.out.print("Faculty abbreviation>");
        String abbr = inputScanner.next();

        inputScanner.close();

        Faculty createFaculty = new Faculty(faf, abbr);

        faculty.add(createFaculty);
    }
    public static void identifyFaculty(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Email>");
        String Email = inputScanner.next();
        inputScanner.close();
        for(Student stud: enrollstud){
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
            System.out.println(f);
        }
    }
    @Override
    public String toString(){
        return "Faculty name: "+name+", "+"Abbreviation: "+abbreviation;
    }
}
