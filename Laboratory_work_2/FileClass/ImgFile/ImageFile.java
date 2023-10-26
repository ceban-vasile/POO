package Laboratory_work_2.FileClass.ImgFile;

import Laboratory_work_2.FileClass.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ImageFile extends Files {
    public int width;
    public int height;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Created Time: " + createTime);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
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
