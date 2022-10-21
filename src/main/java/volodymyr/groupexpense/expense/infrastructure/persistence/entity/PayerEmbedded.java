package volodymyr.groupexpense.expense.infrastructure.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@ToString
@Setter
@NoArgsConstructor
@Embeddable
public class PayerEmbedded {

    private String firstName;

    private String lastName;

    private BigDecimal payment;

    private String currency;


}
