package customlinkedlist;

public class NoElementToRemoveException  extends RuntimeException{
    public NoElementToRemoveException(String message) {
        super(message);
    }
}
