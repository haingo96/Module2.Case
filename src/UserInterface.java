import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    public static void actionController(int studyAct) {
        switch (studyAct) {
            case 1 -> Controller.importWord();
            case 2 -> Controller.editWord();
            case 3 -> Controller.search();
            case 4 -> Controller.removeWord();
            case 5 -> Controller.searchFromDict();
            case 6 -> printIntroMenu();
        }
    }

    public static void studyOptionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                \n
                ======================================
                || Choose what you're gonna do next:||
                || 1. Add a new words               ||
                || 2. Edit existed words            ||
                || 3. Search from my pool           ||
                || 4. Remove words                  ||
                || 5. Dictionary                    ||
                || 6. Back                          ||
                ======================================""");

        actionController(scanner.nextInt());
    }

    public static void printIntroMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                \n
                =========================================
                || Welcome!                            ||
                || What's in your mind:                ||
                || 1. Learn English                    ||
                || 2. Learn Japanese                   ||
                || 3. Quit! No more study for today!!! ||
                =========================================""");

        int userChoice = scanner.nextInt();
        if (userChoice == 1 || userChoice == 2){
            Variables.USERS_LANGUAGE_CHOICE = userChoice;
            studyOptionMenu();
        }else {
            try {
                WriteFileWord.writeToEnFile();
                WriteFileWord.writeToJpFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
