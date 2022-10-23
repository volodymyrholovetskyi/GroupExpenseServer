package volodymyr.groupexpense.expense.domain.value_object;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import volodymyr.groupexpense.expense.domain.exceptions.MoneyInvalidAmountException;
import volodymyr.groupexpense.expense.domain.type.Currency;

import java.math.BigDecimal;

import static volodymyr.groupexpense.expense.domain.type.Currency.*;

@EqualsAndHashCode
@Getter
public class Payment {

    BigDecimal payment;

    Currency currency;

    private Payment(BigDecimal payment, String currency){
        this.payment = payment;
        this.currency = verificationType(currency);
    }

    public static Payment ofPayment(BigDecimal payment, String currency) {
        if (payment.compareTo(BigDecimal.ZERO) < 0) {
            throw new MoneyInvalidAmountException("The value must be greater than zero");
        }
       return new Payment(payment, currency);
    }

    public BigDecimal totalCost(BigDecimal many) {
        return payment.add(many);
    }

    public BigDecimal average(BigDecimal totalCost) {
        return null;
    }
}
