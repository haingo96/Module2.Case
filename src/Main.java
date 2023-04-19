import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ReadFileWord.readFromEnFile();
            ReadFileWord.readFromJpFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Controller.printIntroMenu();
    }
}