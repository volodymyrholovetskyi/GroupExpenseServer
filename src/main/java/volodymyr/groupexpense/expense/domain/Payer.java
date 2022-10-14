package volodymyr.groupexpense.expense.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import volodymyr.groupexpense.expense.domain.vo.FullNamePayer;
import volodymyr.groupexpense.expense.domain.vo.Payment;

@Getter
@ToString
@NoArgsConstructor
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
