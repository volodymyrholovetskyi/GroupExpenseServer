package volodymyr.groupexpense.expense.domain.vo;

import lombok.Getter;

@Getter
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
