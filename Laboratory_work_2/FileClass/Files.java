package Laboratory_work_2.FileClass;

import java.nio.file.attribute.FileTime;

public abstract class Files {
    public String fileName;
    public String extension;

    public FileTime createTime;
    public FileTime snapshot;
    public abstract void printInfo(String filename);
    public abstract void findCreateTime(String filePath);
}
