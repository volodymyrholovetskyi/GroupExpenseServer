package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class ExpenseTestBase {

    public CreateGroupExpenseDTO tripToMountains() {
        return new CreateGroupExpenseDTO("Trip to the mountains");
    }


    public CreateExpenseDTO coffee() {
        return new CreateExpenseDTO(
                "coffee",
                "Volodymyr",
                "Holovetskyi",
                BigDecimal.valueOf(12),
                "PLN"
        );
    }
}