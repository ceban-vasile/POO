package Laboratory_work_1.Faculty;

import java.util.ArrayList;

public class Faculty{
    public String name;
    public String abbreviation;
    public StudyField field;
    public Faculty(){}
    public Faculty(String abbreviation){ this.abbreviation = abbreviation;}
    public Faculty(String name, String abbreviation, StudyField field){
        this.name = name;
        this.abbreviation = abbreviation;
        this.field = field;
    }
    public static  ArrayList<Faculty> faculty = new ArrayList<>();
    @Override
    public String toString(){
        return name+"/"+abbreviation+"/"+field;
    }
}
