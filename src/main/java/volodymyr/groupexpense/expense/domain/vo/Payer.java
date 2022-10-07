package volodymyr.groupexpense.expense.domain.vo;

import lombok.Getter;

@Getter
public class Payer {

    private NamePayer name;
    private Payment payment;

    public Payer(NamePayer name, Payment payment) {
        this.name = name;
        this.payment = payment;
    }
}
