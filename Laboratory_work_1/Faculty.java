package Laboratory_work_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Laboratory_work_1.Student.enrollstud;


public class Faculty{
    String name;
    String abbreviation;
    public Faculty(){}

    public Faculty(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public Faculty(String name, String abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }
    private Student student;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    enum StudyField {
        MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE
    }
    static ArrayList<Faculty> faculty = new ArrayList<>();

    public static void createFaculty(){
        Scanner myScanner = new Scanner(System.in);

        Faculty createFaculty = new Faculty();

        System.out.print("Faculty name>");
        createFaculty.setName(myScanner.next());

        System.out.print("Faculty abbreviation>");
        createFaculty.setAbbreviation(myScanner.next());

        faculty.add(createFaculty);
    }
    public static void searchStudent(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Email>");
        String Email = myScanner.next();
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
    public static void displayFaculty(){
        for(Faculty f: faculty){
            System.out.println(f);
        }
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
                    createFaculty();
                    break;
                case "ss/":
                    searchStudent();
                    break;
                case "df":
                    displayFaculty();
                    break;
                case "df/":
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("You did not enter the correct data!!!");
            }
        }
    }
    @Override
    public String toString(){
        return "Faculty name: "+name+", "+"Abbreviation: "+abbreviation;
    }
}
