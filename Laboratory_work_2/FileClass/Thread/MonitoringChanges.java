package Laboratory_work_2.FileClass.Thread;

import java.io.IOException;
import java.nio.file.*;

public class MonitoringChanges implements Runnable {
    private void checkChanges() throws IOException, InterruptedException {
        Path repository = Paths.get("C:\\Users\\Vasile\\Desktop\\test_repository\\");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        repository.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key = watchService.take();

        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();
            Path pathFileName = (Path) event.context();

            if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                System.out.println(pathFileName.getFileName() + " new file");
            } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                System.out.println(pathFileName.getFileName() + " Delete");
            } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                System.out.println(pathFileName.getFileName() + " Changed");
            }
        }
        key.reset();
    }
    @Override
    public void run() {
        try {
        while (true) {
            try {
                checkChanges();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        } catch (RuntimeException e) {
            System.out.println("Thread was interrupted!");
        }
    }
}
