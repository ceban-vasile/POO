package Laboratory_work_2.FileClass;

import java.nio.file.attribute.FileTime;

public abstract class Files {
    protected String fileName;
    protected String extension;
    protected FileTime createTime;
    protected FileTime snapshot;
    protected abstract void printInfo(String filename);
    protected abstract void getCreateTime(String filePath);
}
