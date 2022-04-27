package ServiceAccessLayer.customExceptions;

public class BadConnectionError extends RuntimeException {
    public BadConnectionError(String message) {super(message);}
}
