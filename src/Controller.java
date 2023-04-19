import java.util.Scanner;

public class Controller {
    public static void actionController(int studyAct) {
        switch (studyAct) {
            case 1 -> UserInterface.importWord();
            case 2 -> UserInterface.editWord();
            case 3 -> UserInterface.search();
            case 4 -> UserInterface.removeWord();
            case 6 -> printIntroMenu();
        }
    }

    public static void studyOptionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                \n
                Choose what you're gonna do next:
                1. Add a new words
                2. Edit existed words
                3. Search from my pool
                4. Remove words
                5. Try a test
                6. Back""");

        actionController(scanner.nextInt());
    }

    public static void printIntroMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                \n
                Welcome!
                What's in your mind:
                1. Learn English
                2. Learn Japanese
                3. Quit! No study today!!!""");

        int userChoice = scanner.nextInt();
        if (userChoice == 1 || userChoice == 2){
            Variables.USERS_LANGUAGE_CHOICE = userChoice;
        }

        studyOptionMenu();
    }
}
