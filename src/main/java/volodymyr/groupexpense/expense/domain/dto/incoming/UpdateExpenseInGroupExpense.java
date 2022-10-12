package volodymyr.groupexpense.expense.domain.dto.incoming;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateExpenseInGroupExpense (

    String expenseName,
    String firstName,
    String lastName,
    BigDecimal payment,
    LocalDateTime createTime,
    String currency
){}
