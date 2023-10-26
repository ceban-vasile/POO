package Laboratory_work_2.File.TxtFile;

import Laboratory_work_2.File.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class TextFile extends File {
    public int lineCount;
    public int wordCount;
    public int charCount;

    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Created Snapshot at: " + createTime);
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
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
