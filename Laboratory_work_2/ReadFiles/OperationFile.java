package Laboratory_work_2.ReadFiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationFile {
    public List<Integer> readTxtFile(String path){
        int wordCount = 0;
        int charCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countInfo.add(wordCount);
        countInfo.add(charCount);
        countInfo.add(lineCount);
        return countInfo;
    }
    public List<Integer> readProgramFile(String path){
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                boolean insideImport = false;

                if (line.startsWith("import ") || line.startsWith("package ")) {
                    insideImport = true;
                } else if (insideImport && line.endsWith(";")) {
                    insideImport = false;
                } else if (!insideImport && (line.startsWith("public") || line.startsWith("private") || line.startsWith("abstract")) && line.contains(" class ")) {
                    classCount++;
                } else if (!insideImport && (line.startsWith("public") || line.startsWith("private") || line.startsWith("abstract") || line.startsWith("protected") || line.startsWith("static")) && line.contains("(") && line.endsWith(") {")) {
                    methodCount++;
                }
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        countInfo.add(lineCount);
        countInfo.add(classCount);
        countInfo.add(methodCount);
        return countInfo;
    }
    public List<Integer> readImageFile(String path){
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File(path));
            if (image != null) {
                countInfo.add(image.getWidth());
                countInfo.add(image.getHeight());
            } else {
                System.out.println("The image could not be read.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countInfo;
    }
}