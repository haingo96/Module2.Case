import java.util.Scanner;

public class UserInterface {
    public static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the word you want to know about:");
        String toSearchWord = scanner.nextLine();

        if (Variables.USERS_LANGUAGE_CHOICE == 1){
            Variables.enWordManager.display(toSearchWord);
        }else if (Variables.USERS_LANGUAGE_CHOICE == 2) {
            Variables.jpWordManager.display(toSearchWord);
        }

        if (!checkEndOfAction()){
            search();
        }else {
            Controller.studyOptionMenu();
        }
    }

    public static void importWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your word you want to input");
        String inputSpell = scanner.nextLine();
        System.out.println("Input its mean:");
        String inputMean = scanner.nextLine();

        if (Variables.USERS_LANGUAGE_CHOICE == 1){
            Variables.enWordManager.add(new EnglishWord(inputSpell, inputMean));
        }else if (Variables.USERS_LANGUAGE_CHOICE == 2) {
            Variables.jpWordManager.add(new JapaneseWord(inputSpell, inputMean));
        }

        if (!checkEndOfAction()){
            importWord();
        }else {
            Controller.studyOptionMenu();
        }
    }

    public static void editWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the word you want to edit its mean:");
        String inputSpell = scanner.nextLine();
        System.out.println("Input its new mean");
        String inputNewMean = scanner.nextLine();

        if (Variables.USERS_LANGUAGE_CHOICE == 1){
            Variables.enWordManager.edit(inputSpell, inputNewMean);
        }else if (Variables.USERS_LANGUAGE_CHOICE == 2) {
            Variables.jpWordManager.edit(inputSpell, inputNewMean);
        }

        if (!checkEndOfAction()){
            editWord();
        }else {
            Controller.studyOptionMenu();
        }
    }

    public static void removeWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the word you want to remove:");
        String inputSpell = scanner.nextLine();

        if (Variables.USERS_LANGUAGE_CHOICE == 1){
            Variables.enWordManager.remove(inputSpell);
        }else if (Variables.USERS_LANGUAGE_CHOICE == 2) {
            Variables.jpWordManager.remove(inputSpell);
        }

        if (!checkEndOfAction()){
            removeWord();
        }else {
            Controller.studyOptionMenu();
        }
    }

    private static boolean checkEndOfAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Are you done? Yes/No");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("no")){
            return false;
        } else {
            return true;
        }
    }
}
