import java.io.*;
import java.util.List;

public class ReadDataFromDictionary {
    public static void readFromEnDict() throws IOException {
        List<Word> enWords = Variables.enDict.getWords();
        File enDictionary = new File("common-english-viet-words.txt");

        FileReader fileReader = new FileReader(enDictionary);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";
        while ((line = reader.readLine()) != null) {
            StringReader stringReader = new StringReader(line);
            String spell = "";
            String mean = "";
            int ch;
            while ((ch = stringReader.read()) != 9) {
                spell += (char) ch;
            }

            stringReader.read();
            while ((ch = stringReader.read()) != -1) {
                mean += (char) ch;
            }

            enWords.add(new EnglishWord(spell, mean));
        }
    }
}
