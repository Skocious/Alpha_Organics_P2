package entities;


import java.util.Objects;

public class Login {
    private String Username;
    private String Password;

    public Login(){}

    public Login(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
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
        return Username.equals(login.Username) && Password.equals(login.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Username, Password);
    }

    @Override
    public String toString() {
        return "Login{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}

