package Laboratory_work_2.File.ImgFile;

import Laboratory_work_2.File.File;

public class ImageFile extends File {
    public int width;
    public int height;
    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }

}
