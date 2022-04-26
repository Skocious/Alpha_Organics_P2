package customExceptions;

public class LoginError extends RuntimeException{

    public LoginError(String message) {super(message);}
}
