package Laboratory_work_1;

import java.text.ParseException;

import static Laboratory_work_1.FileManager.readStudent;
import static Laboratory_work_1.Menu.tumMenu;

public class Main {
    public static void main(String[] args) throws ParseException {
        tumMenu();
        readStudent();
    }
}
