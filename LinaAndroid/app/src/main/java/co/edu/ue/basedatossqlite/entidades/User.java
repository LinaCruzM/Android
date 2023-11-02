package co.edu.ue.basedatossqlite.entidades;

public class User {

    private int document;
    private String user;
    private  String names;
    private String lastNames;
    private String password;

    public User(){

    }

    public User(int document, String user, String names, String lastNames, String password) {
        this.document = document;
        this.user = user;
        this.names = names;
        this.lastNames = lastNames;
        this.password = password;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "document=" + document +
                ", user='" + user + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
