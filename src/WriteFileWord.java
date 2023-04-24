import java.io.*;

public class WriteFileWord {
    public static void writeToEnFile() throws IOException {
        File enFile = new File(Variables.LOGGING_IN_USER.getEnWordFilePath());
        if (!enFile.exists()) {
            enFile.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(enFile);
        for (int i = 0; i < Variables.enWordManager.getWords().size(); i++) {
            fileWriter.write(Variables.enWordManager.getWords().get(i).toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void writeToJpFile() throws IOException {
        File jpFile = new File(Variables.LOGGING_IN_USER.getJpWordFilePath());
        if (!jpFile.exists()) {
            jpFile.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(jpFile);
        for (int i = 0; i < Variables.jpWordManager.getWords().size(); i++) {
            fileWriter.write(Variables.jpWordManager.getWords().get(i).toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
