package Laboratory_work_2;

import Laboratory_work_2.FileClass.Monitor.FileMonitor;
import Laboratory_work_2.FileClass.Thread.MonitoringChanges;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MonitoringChanges());
        thread.start();
        FileMonitor command = new FileMonitor();
        command.writeCommand();
        thread.interrupt();
    }
}
