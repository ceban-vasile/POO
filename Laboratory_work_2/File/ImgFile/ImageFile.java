package Laboratory_work_2.File.ImgFile;

import Laboratory_work_2.File.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ImageFile extends File {
    public int width;
    public int height;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Created Snapshot at: " + createTime);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
    @Override
    public void findCreateTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            createTime = attr.creationTime();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
