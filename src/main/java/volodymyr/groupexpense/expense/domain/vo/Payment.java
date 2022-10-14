package volodymyr.groupexpense.expense.domain.vo;

import volodymyr.groupexpense.expense.domain.exceptions.MoneyInvalidAmountException;
import volodymyr.groupexpense.expense.domain.type.Currency;

import java.math.BigDecimal;

import static volodymyr.groupexpense.expense.domain.type.Currency.*;

public class Payment {

    BigDecimal payment;

    Currency currency;

    private Payment(BigDecimal payment, String currency){
        if (payment.compareTo(BigDecimal.ZERO) < 0) {
            throw new MoneyInvalidAmountException("The value must be greater than zero");
        }
        this.payment = payment;
        this.currency = verificationType(currency);
    }

    public static Payment createPayment(BigDecimal payment, String currency) {
       return new Payment(payment, currency);
    }

    public BigDecimal totalCost(BigDecimal many) {
        return payment.add(many);
    }

    public BigDecimal average(BigDecimal totalCost) {
        return null;
    }
}
