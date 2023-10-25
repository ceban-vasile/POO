package Laboratory_work_2.File.FIleMonitor;

import Laboratory_work_2.File.File;
import Laboratory_work_2.File.ImgFile.ImageFile;
import Laboratory_work_2.File.ProgramFile.ProgramFile;
import Laboratory_work_2.File.TxtFile.TextFile;
import Laboratory_work_2.ReadFiles.OperationFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMonitor extends File{
    TextFile txtFile;

    {
        txtFile = new TextFile();
    }
    ProgramFile programFile = new ProgramFile();
    OperationFile file = new OperationFile();
    ImageFile imageFile = new ImageFile();
    public void commit() {

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
                txtFile.printInfo();
            }
            case "py", "java" -> {
                countInfo.clear();
                countInfo = file.readProgramFile(repository + fileName);
                programFile.lineCount = countInfo.get(0);
                programFile.classCount = countInfo.get(1);
                programFile.methodCount = countInfo.get(2);
                programFile.fileName = fileName;
                programFile.extension = extension;
                programFile.printInfo();
            }
            case "png", "jpg" -> {
                countInfo.clear();
                countInfo = file.readImageFile(repository + fileName);
                imageFile.fileName = fileName;
                imageFile.extension = extension;
                imageFile.width = countInfo.get(0);
                imageFile.height = countInfo.get(1);
                imageFile.printInfo();
            }
        }
    }
    public void status() {

    }

    public void printInfo(){

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
                default -> {System.out.println("Is not valid command!!!");}
            }
        }
        inputScanner.close();
    }

}
