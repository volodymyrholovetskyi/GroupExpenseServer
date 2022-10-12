package volodymyr.groupexpense.expense.domain.dto.incoming;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CreateExpenseDTO {

    private String expenseName;
    private String firstName;
    private String lastName;
    private BigDecimal payment;
    private LocalDateTime createTime;
    private String currency;

}
