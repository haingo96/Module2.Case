import java.io.*;

public class WriteFileUserPool {
    public static void writeUserPool() throws IOException {
        File userDataFile = new File("userPool.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(userDataFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(UserManager.getUsers());
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
