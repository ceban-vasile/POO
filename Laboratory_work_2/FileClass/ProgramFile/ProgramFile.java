package Laboratory_work_2.FileClass.ProgramFile;

import Laboratory_work_2.FileClass.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ProgramFile extends Files {
    public int lineCount;
    public int classCount;
    public int methodCount;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Created Time: " + createTime);
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }

    @Override
    public void findCreateTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = java.nio.file.Files.readAttributes(file, BasicFileAttributes.class);
            createTime = attr.creationTime();
            updateTime = attr.lastModifiedTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
