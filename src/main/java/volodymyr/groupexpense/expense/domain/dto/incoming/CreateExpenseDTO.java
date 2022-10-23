package volodymyr.groupexpense.expense.domain.dto.incoming;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateExpenseDTO (


    String description,
    String firstName,
    String lastName,
    BigDecimal payment,
    String currency
){}
