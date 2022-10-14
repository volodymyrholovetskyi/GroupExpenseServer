package volodymyr.groupexpense.expense.domain.exceptions;

public class MoneyInvalidCurrencyException extends RuntimeException{

    public MoneyInvalidCurrencyException(String message) {
        super(message);
    }
}
