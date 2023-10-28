package Laboratory_work_2;

import Laboratory_work_2.FileClass.Monitor.FileMonitor;
import Laboratory_work_2.FileClass.Thread.CheckChanges;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new CheckChanges());
        thread.start();
        FileMonitor command = new FileMonitor();
        command.writeCommand();
    }
}
