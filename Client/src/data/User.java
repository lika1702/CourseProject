package data;

public class User {

    private String login;
    private String password;
    private String admin;
    private boolean banned;
    private String email;

    public User(String login, String password, String admin, boolean banned, String email) {
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.banned = banned;
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAdmin() {
        return this.admin;
    }

    public boolean isBanned() {
        return this.banned;
    }
    
    public String getEmail() {
        return this.email;
    }
}
