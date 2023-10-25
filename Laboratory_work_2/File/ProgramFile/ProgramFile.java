package Laboratory_work_2.File.ProgramFile;

import Laboratory_work_2.File.File;

public class ProgramFile extends File {
    int lineCount;
    int classCount;
    int methodCount;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }
}
