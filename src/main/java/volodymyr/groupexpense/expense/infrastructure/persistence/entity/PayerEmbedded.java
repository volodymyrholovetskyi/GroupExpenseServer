package volodymyr.groupexpense.expense.infrastructure.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@ToString
@Setter
@NoArgsConstructor
@SuperBuilder
@Embeddable
public class PayerEmbedded {

    private String name;

    private BigDecimal payment;

    private String currency;


}
