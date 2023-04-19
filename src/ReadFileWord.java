import java.io.*;
import java.util.List;

public class ReadFileWord {
    public static void readFromEnFile() throws IOException {
        List<Word> enWords = Variables.enWordManager.getWords();

        File enFile = new File("enWord.txt");
        FileReader fileReader = new FileReader(enFile);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";
        while ((line = reader.readLine()) != null) {
            StringReader stringReader = new StringReader(line);
            String spell = "";
            String mean = "";
            int ch;
            while ((ch = stringReader.read()) != 58){
                spell += (char) ch;
            }
            stringReader.read();
            while ((ch = stringReader.read()) != 39){
                mean += (char) ch;
            }
            enWords.add(new EnglishWord(spell, mean));
        }
    }

    public static void readFromJpFile() throws IOException {
        List<Word> jpWords = Variables.jpWordManager.getWords();

        File jpFile = new File("jpWord.txt");
        FileReader fileReader = new FileReader(jpFile);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";
        while ((line = reader.readLine()) != null) {
            StringReader stringReader = new StringReader(line);
            String spell = "";
            String mean = "";
            int ch;
            while ((ch = stringReader.read()) != 58){
                spell += (char) ch;
            }
            stringReader.read();
            while ((ch = stringReader.read()) != 39){
                mean += (char) ch;
            }
            jpWords.add(new JapaneseWord(spell, mean));
        }
    }
}
