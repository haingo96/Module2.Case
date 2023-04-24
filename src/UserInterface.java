import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    public static void printLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ===============================================
                || Please log in to use our services         ||
                || Sign up in case you don't have account... ||
                || 1. Log in                                 ||
                || 2. Sign up                                ||
                || 3. Quit                                   ||
                ===============================================""");

        int introAction = scanner.nextInt();

        if (introAction == 1) {
            UserController.logIn();
        } else if (introAction == 2) {
            UserController.signUp();
        }else {
            try {
                WriteFileUserPool.writeUserPool();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void studyActivityController(int studyAct) {
        switch (studyAct) {
            case 1 -> StudyController.importWord();
            case 2 -> StudyController.editWord();
            case 3 -> StudyController.search();
            case 4 -> StudyController.removeWord();
            case 5 -> StudyController.searchFromDict();
            case 6 -> printLanguageOptions();
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

        studyActivityController(scanner.nextInt());
    }

    public static void printLanguageOptions() {
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
                Variables.enWordManager.clear();
                Variables.jpWordManager.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                printLoginMenu();
            }
        }
    }
}
