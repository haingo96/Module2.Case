import java.util.ArrayList;
import java.util.List;

public class WordManager{
    private List<Word> words = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

    public void add(Word word){
        boolean wordIsExisted = words.stream().map(word1 -> word1.getSpell()).toList().contains(word.getSpell());
        if (!wordIsExisted){
            words.add(word);
        }else {
            System.out.println("\"" + word.getSpell() + "\"" + " existed" + "\n" + "add is not allowed");
        }
    }

    public void remove(String spell){
        Word wordMatchSpell = words.stream().filter(word -> word.getSpell().equals(spell)).findFirst().get();
        words.remove(wordMatchSpell);
    }

    public void edit(String spell, String newMean){
        Word matchWord = words.stream().filter(word1 -> word1.getSpell().equals(spell)).findFirst().get();
        matchWord.setMean(newMean);
    }

    public void display(String spell){
        List<Word> holder = words.stream().filter(word1 -> word1.getSpell().contains(spell)).toList();
        String result = holder.toString();
        System.out.println(result.replaceAll(",", "\n"));
    }
}
