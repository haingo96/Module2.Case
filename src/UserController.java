import java.io.IOException;
import java.util.Scanner;

public class UserController {
    public static void signUp() {
        System.out.println("-----SIGN UP-----");
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.println("Input your id for signing up:");
            id = scanner.nextLine();
            if (isInputIdAlreadyExisted(id)) {
                System.out.println("Id already existed \nChoose another id...\n");
            }
        }while (isInputIdAlreadyExisted(id));

        System.out.println("Input your password:");
        String password = scanner.nextLine();

        UserManager.add(new User(id, password));
        System.out.println("Signed up successfully\n");

        logIn();
    }

    public static void logIn() {
        System.out.println("-----LOG IN-----");
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.println("Input your id for logging in:");
            id = scanner.nextLine();
            if (!isInputIdAlreadyExisted(id)) {
                System.out.println("Input id does not exist \nInput your id again correctly...\n");
            }
        }while (!isInputIdAlreadyExisted(id));

        String finalId = id;
        User userMatchInputId = UserManager.getUsers().stream().filter(user1 -> user1.getId().equals(finalId)).findFirst().get();
        String password;
        do {
            System.out.println("Input your password:");
            password = scanner.nextLine();
            if (!userMatchInputId.getPassword().equals(password)) {
                System.out.println("Input password is not correct \nInput your password correctly...\n");
            }
        } while (!userMatchInputId.getPassword().equals(password));

        System.out.println("Logged in successfully\n");

        Variables.LOGGING_IN_USER = userMatchInputId;

        loadUserData();

        UserInterface.printLanguageOptions();
    }

    private static void loadUserData() {
        try {
            System.out.println("Loading data ... \nPlease wait");
            ReadDataFromDictionary.readFromEnDict();
            ReadFileWord.readFromEnFile();
            ReadFileWord.readFromJpFile();
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isInputIdAlreadyExisted(String id) {
        boolean inputIdAlreadyExisted = UserManager.getUsers()
                .stream()
                .map(user -> user.getId())
                .toList().contains(id);
        return inputIdAlreadyExisted;
    }
}
