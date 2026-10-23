package agorlab.willy.exceptions.response;

public class UnsafeToDeleteException extends RuntimeException {
    public UnsafeToDeleteException(String message) {
        super(message);
    }
}
