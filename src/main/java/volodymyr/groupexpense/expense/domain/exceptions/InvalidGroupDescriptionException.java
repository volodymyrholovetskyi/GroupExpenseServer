package volodymyr.groupexpense.expense.domain.exceptions;

public class InvalidGroupDescriptionException extends RuntimeException{
    public InvalidGroupDescriptionException(String message){
        super("Incorrect name: %s".formatted(message));
    }
}
