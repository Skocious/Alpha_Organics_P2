package src.Samantha.Entities;

import java.util.Objects;

public class Login {
    int LoginId;
    String Username;
    String Password;

    public Login(){}

    public Login(int LoginId, String Username, String Password) {
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return LoginId == login.LoginId && Username.equals(login.Username) && Password.equals(login.Password);
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
                ", Password='" + Password + '\'' +
                '}';
    }
}

