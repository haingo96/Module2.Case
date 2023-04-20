import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Loading data ... \nPlease wait");
            ReadDataFromDictionary.readFromEnDict();
            ReadFileWord.readFromEnFile();
            ReadFileWord.readFromJpFile();
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UserInterface.printIntroMenu();
    }
}