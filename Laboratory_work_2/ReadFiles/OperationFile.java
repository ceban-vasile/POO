package Laboratory_work_2.ReadFiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationFile {
    public void writeModification(File[] files){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file_info.txt"))) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
                    writer.write(fileName + "/" + lastModifiedTime + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    public List<Integer> readJavaFile(String path) {
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            Pattern classPattern = Pattern.compile("\\b(class|interface|enum)\\s+\\w+\\s*\\{");
            Pattern methodPattern = Pattern.compile("\\b\\w+(?:<[^>]+>)?\\s+\\w+\\s*\\([^)]*\\)\\s*(?:throws\\s+\\w+(?:,\\s*\\w+)*)?\\s*\\{");
            while ((line = reader.readLine()) != null) {
                Matcher classMatcher = classPattern.matcher(line);
                Matcher methodMatcher = methodPattern.matcher(line);
                if (classMatcher.find()) {
                    classCount++;
                }
                else if (methodMatcher.find()) {
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
    public List<Integer> readPythonFile(String path) {
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("class ")) {
                    classCount++;
                } else if (line.matches("\\s*def\\s+\\w+\\s*\\([^)]*\\):")) {
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
