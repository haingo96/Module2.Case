public class Main {
    public static void main(String[] args) {
        try {
            ReadFileUserPool.readUserPool();
        } catch (Exception e) {
        }

        UserInterface.printLoginMenu();
    }
}