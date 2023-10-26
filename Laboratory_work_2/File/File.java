package Laboratory_work_2.File;

import java.nio.file.attribute.FileTime;

public abstract class File {
    public String fileName;
    public String extension;

    public FileTime createTime;
    public String updateTime;
    public abstract void printInfo();
    public abstract void findCreateTime(String filePath);
}
