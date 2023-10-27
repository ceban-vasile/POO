package Laboratory_work_2.FileClass.FIleMonitor;

import Laboratory_work_2.FileClass.Files;
import Laboratory_work_2.FileClass.ImgFile.ImageFile;
import Laboratory_work_2.FileClass.ProgramFile.ProgramFile;
import Laboratory_work_2.FileClass.TxtFile.TextFile;
import Laboratory_work_2.ReadFiles.OperationFile;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
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
        FileTime currentFileTime = FileTime.from(Instant.now());
        file.writeSnapshot(currentFileTime);
    }
    public void status() {
        String repository = "C:\\Users\\Vasile\\Desktop\\test_repository\\";
        File folder = new File(repository);
        File[] files = folder.listFiles();
        snapshot = file.readSnapshot();
        infoStatus();
        for(File file: files){
            String fileName = file.getName();
            FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
            int comparisonResultMod = lastModifiedTime.compareTo(snapshot);
            if (comparisonResultMod > 0) {
                System.out.println(fileName+" - Changed");
            }else if(comparisonResultMod < 0){
                System.out.println(fileName+" - No changed");
            }
        }
    }
    public void infoStatus(){

    }
    public void printInfo(String filename){
       // System.out.println("Created Snapshot at: " + snapshot);
        extension = findExtension(filename);
        switch (extension){
            case "txt" -> {txtFile.printInfo(filename);}
            case "java", "py" -> {programFile.printInfo(filename);}
            case "png", "jpg" -> {imageFile.printInfo(filename);}
        }
    }
    private void help(){
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
                    printInfo(fileName);
                }
                case "status" -> {status();}
                case "help" -> {help();}
                case "exit" -> {isCommand = 0;}
                default -> {System.out.println("Is not valid command!!! \n" +
                        "For more information, write help in the console");}
            }
        }
        inputScanner.close();
    }

}
