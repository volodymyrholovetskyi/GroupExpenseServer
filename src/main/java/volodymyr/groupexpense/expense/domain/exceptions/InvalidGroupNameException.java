package volodymyr.groupexpense.expense.domain.exceptions;

public class InvalidGroupNameException extends RuntimeException{
    public InvalidGroupNameException(String message){
        super("Group name is invalid: %s".formatted(message));
    }
}
