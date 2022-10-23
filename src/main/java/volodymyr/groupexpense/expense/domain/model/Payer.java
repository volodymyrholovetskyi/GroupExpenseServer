package volodymyr.groupexpense.expense.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import volodymyr.groupexpense.expense.domain.value_object.FullNamePayer;
import volodymyr.groupexpense.expense.domain.value_object.Payment;

@Getter
@ToString
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class Payer {

    private FullNamePayer name;
    private Payment payment;

    private Payer(FullNamePayer name, Payment payment) {
        this.name = name;
        this.payment = payment;
    }

    public static Payer createPayer(FullNamePayer fullName, Payment payment){
        return new Payer(fullName, payment);
    }
}
