package customExceptions;

public class InvalidLogin extends RuntimeException{
    public InvalidLogin(String message){
        super(message);
    }
}
