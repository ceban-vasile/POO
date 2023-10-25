package Laboratory_work_2.File.FIleMonitor;

import Laboratory_work_2.File.File;
import Laboratory_work_2.File.TxtFile.TextFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileMonitor extends File{
    TextFile txtFile;

    {
        txtFile = new TextFile();
    }

    public void commit() {

    }
    public void info(String fileName) {
        String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(repository+fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                txtFile.wordCount += words.length;
                txtFile.charCount += line.length();
                txtFile.lineCount++;
            }
            txtFile.extension = findExtension(fileName);
            txtFile.fileName = fileName;
            txtFile.printInfo();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
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
