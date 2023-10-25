package Laboratory_work_2.File.TxtFile;

import Laboratory_work_2.File.File;

public class TextFile extends File {
    public int lineCount;
    public int wordCount;
    public int charCount;

    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }
}
