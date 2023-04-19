import java.io.*;

public class WriteFileWord {
    public static void writeToEnFile() throws IOException {
        File enFile = new File("enWord.txt");

        FileWriter fileWriter = new FileWriter(enFile);
        for (int i = 0; i < Variables.enWordManager.getWords().size(); i++) {
            fileWriter.write(Variables.enWordManager.getWords().get(i).toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void writeToJpFile() throws IOException {
        File jpFile = new File("jpWord.txt");

        FileWriter fileWriter = new FileWriter(jpFile);
        for (int i = 0; i < Variables.jpWordManager.getWords().size(); i++) {
            fileWriter.write(Variables.jpWordManager.getWords().get(i).toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
