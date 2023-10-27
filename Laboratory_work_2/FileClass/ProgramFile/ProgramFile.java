package Laboratory_work_2.FileClass.ProgramFile;

import Laboratory_work_2.FileClass.Files;
import Laboratory_work_2.ReadFiles.OperationFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ProgramFile extends Files {
    public int lineCount;
    public int classCount;
    public int methodCount;
    OperationFile file = new OperationFile();
    @Override
    public void printInfo(String filename) {
        String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
        List<Integer> countInfo = new ArrayList<>();
        fileName = filename;
        extension = findExtension(repository + fileName);
        if(extension.equals("java")) {
            countInfo = file.readJavaFile(repository + filename);
        }else if(extension.equals("py")){
            countInfo = file.readPythonFile(repository + filename);
        }
        lineCount = countInfo.get(0);
        classCount = countInfo.get(1);
        methodCount = countInfo.get(2);
        findCreateTime(repository + fileName);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String findExtension(String fileName){

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
