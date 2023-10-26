package Laboratory_work_2.FileClass.FIleMonitor;

import Laboratory_work_2.FileClass.Files;
import Laboratory_work_2.FileClass.ImgFile.ImageFile;
import Laboratory_work_2.FileClass.ProgramFile.ProgramFile;
import Laboratory_work_2.FileClass.TxtFile.TextFile;
import Laboratory_work_2.ReadFiles.OperationFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMonitor extends Files {
    TextFile txtFile;

    {
        txtFile = new TextFile();
    }
    ProgramFile programFile = new ProgramFile();
    OperationFile file = new OperationFile();
    ImageFile imageFile = new ImageFile();
    public void commit() {
            String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
            File folder = new File(repository);
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                file.writeModification(files);
            } else {
                System.out.println("Calea specificată nu este către un folder.");
            }
    }
    public void info(String fileName) {
        String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
        List<Integer> countInfo = new ArrayList<>();
        String extension = findExtension(fileName);
        switch (extension) {
            case "txt" -> {
                countInfo.clear();
                countInfo = file.readTxtFile(repository + fileName);
                txtFile.wordCount = countInfo.get(0);
                txtFile.charCount = countInfo.get(1);
                txtFile.lineCount = countInfo.get(2);
                txtFile.fileName = fileName;
                txtFile.extension = extension;
                txtFile.findCreateTime(repository + fileName);
                txtFile.printInfo();
            }
            case "java" -> {
                countInfo.clear();
                countInfo = file.readJavaFile(repository + fileName);
                programFile.lineCount = countInfo.get(0);
                programFile.classCount = countInfo.get(1);
                programFile.methodCount = countInfo.get(2);
                programFile.fileName = fileName;
                programFile.extension = extension;
                programFile.findCreateTime(repository + fileName);
                programFile.printInfo();
            }
            case "py" -> {
                countInfo.clear();
                countInfo = file.readPythonFile(repository + fileName);
                programFile.lineCount = countInfo.get(0);
                programFile.classCount = countInfo.get(1);
                programFile.methodCount = countInfo.get(2);
                programFile.fileName = fileName;
                programFile.extension = extension;
                programFile.findCreateTime(repository + fileName);
                programFile.printInfo();
            }
            case "png", "jpg" -> {
                countInfo.clear();
                countInfo = file.readImageFile(repository + fileName);
                imageFile.fileName = fileName;
                imageFile.extension = extension;
                imageFile.width = countInfo.get(0);
                imageFile.height = countInfo.get(1);
                imageFile.findCreateTime(repository + fileName);
                imageFile.printInfo();
            }
        }
    }
    public void status() {

    }
    public void printInfo(){
        System.out.println("1. commit -  Simply update the snapshot time to the current time.\n" +
                           "2. info<filName> - prints general information about the file.\n" +
                           "3. status - When calling status an iteration\n" +
                "occurs through all the files stored in program memory and prints if they were\n" +
                "changed during snapshot time and current time.");
    }

    @Override
    public void findCreateTime(String filePath) {

    }

    private String findExtension(String fileName){

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public void writeCommand(){
        Scanner inputScanner = new Scanner(System.in);
        int isCommand = 1;
        while(isCommand == 1){
            System.out.print(">");
            String command = inputScanner.next();
            switch(command){
                case "commit" -> {commit();}
                case "info" -> {
                    String fileName = inputScanner.next();
                    info(fileName);
                }
                case "status" -> {status();}
                case "help" -> {printInfo();}
                default -> {System.out.println("Is not valid command!!! \n" +
                        "For more information, write help in the console");}
            }
        }
        inputScanner.close();
    }

}
