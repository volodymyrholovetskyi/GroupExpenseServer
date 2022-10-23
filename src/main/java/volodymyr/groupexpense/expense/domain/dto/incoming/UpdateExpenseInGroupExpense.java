package volodymyr.groupexpense.expense.domain.dto.incoming;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateExpenseInGroupExpense(
        Long groupId,
        String groupDescription,
        String status,
        LocalDateTime createTimeGroup,
        String expenseDescription,
        String firstName,
        String lastName,
        BigDecimal payment,
        LocalDateTime createTime,
        String currency
) {
}
