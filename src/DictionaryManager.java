import java.util.List;

public class DictionaryManager extends WordManager {
    @Override
    public void display(String spell) {
        List<Word> holder = this.getWords().stream().filter(word -> word.getSpell().equalsIgnoreCase(spell)).findFirst().stream().toList();
        if (holder.isEmpty()) {
            System.out.println("No such word in dictionary. Sorry!!");
        } else {
            Word result = this.getWords().stream().filter(word -> word.getSpell().equalsIgnoreCase(spell)).findFirst().get();
            String resultString = result.getMean().toString();
            resultString = resultString.replaceAll("\\\\n", "\n");
            resultString = resultString.replaceAll("\\+", "->");
            resultString = resultString.replaceAll("=", "vd: ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(resultString);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
