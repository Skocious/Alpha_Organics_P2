package entities;


import java.util.Objects;

public class Login {
    private int LoginId;
    private String Username;
    private int Password;

    public Login(){}

    public Login(int LoginId, String Username, int Password) {
        this.LoginId = LoginId;
        this.Username = Username;
        this.Password = Password;
    }

    public int getLoginId() {
        return LoginId;
    }

    public void setLoginId(int loginId) {
        LoginId = loginId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return LoginId == login.LoginId && Password == login.Password && Objects.equals(Username, login.Username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LoginId, Username, Password);
    }

    @Override
    public String toString() {
        return "Login{" +
                "LoginId=" + LoginId +
                ", Username='" + Username + '\'' +
                ", Password=" + Password +
                '}';
    }
}

