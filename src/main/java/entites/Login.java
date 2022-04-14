package src.Samantha.Entities;

import java.util.Objects;

public class Login {
    int LoginId;
    String Username;
    String pw;

    public Login(){}

    public Login(int LoginId, String Username, String pw) {
        this.LoginId = LoginId;
        this.Username = Username;
        this.pw = pw;
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

    public String getpw() {
        return pw;
    }

    public void setpw(String pw) {
        pw = pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return LoginId == login.LoginId && Username.equals(login.Username) && pw.equals(login.pw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LoginId, Username, pw);
    }

    @Override
    public String toString() {
        return "Login{" +
                "LoginId=" + LoginId +
                ", Username='" + Username + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}

