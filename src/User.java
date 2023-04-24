import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String password;
    private String enWordFilePath;
    private String jpWordFilePath;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEnWordFilePath() {
        return enWordFilePath;
    }

    public String getJpWordFilePath() {
        return jpWordFilePath;
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        enWordFilePath = "enWord_" + id;
        jpWordFilePath = "jpWord_" + id;
    }
}
