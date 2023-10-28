package Laboratory_work_2.FileClass.ImgFile;

import Laboratory_work_2.FileClass.Files;
import Laboratory_work_2.ReadFiles.OperationFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class ImageFile extends Files {
    public int width;
    public int height;
    OperationFile file = new OperationFile();
    @Override
    public void printInfo(String filename) {
        String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
        List<Integer> countInfo;
        countInfo = file.readImageFile(repository + filename);
        width = countInfo.get(0);
        height = countInfo.get(1);
        fileName = filename;
        extension = findExtension(repository + fileName);
        findCreateTime(repository + fileName);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String findExtension(String fileName){

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}