package Laboratory_work_2.File.ProgramFile;

import Laboratory_work_2.File.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ProgramFile extends File {
    public int lineCount;
    public int classCount;
    public int methodCount;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Created Snapshot at: " + createTime);
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }

    @Override
    public void findCreateTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            createTime = attr.creationTime();
            updateTime = attr.lastModifiedTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
