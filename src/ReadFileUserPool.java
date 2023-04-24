import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFileUserPool {
    public static void readUserPool() throws IOException, ClassNotFoundException {
        File userDataFile = new File("userPool.txt");
        FileInputStream fileInputStream = new FileInputStream(userDataFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserManager.setUsers((List<User>) objectInputStream.readObject());
        objectInputStream.close();
    }
}
