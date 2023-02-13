package entity;

public class Housemaster_login {
    private String id;
    private String password;

    public Housemaster_login() {
    }

    public Housemaster_login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
