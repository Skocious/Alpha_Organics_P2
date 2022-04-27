package ServiceAccessLayer.customExceptions;

public class InvalidId extends RuntimeException{
    public InvalidId(String message){
        super(message);
    }
}
