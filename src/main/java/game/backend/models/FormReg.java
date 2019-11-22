package game.backend.models;
/**
 * FormReg it's a class to just send the registration and login data
 * from Android
 */
public class FormReg {
    String username;
    String password;
    String name;
    public FormReg(){}

    public FormReg(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public FormReg(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
