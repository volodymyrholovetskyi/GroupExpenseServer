package volodymyr.groupexpense.expense.domain.exceptions;

public class MoneyInvalidAmountException extends RuntimeException {

    public MoneyInvalidAmountException(String message){
        super(message);
    }
}
