package volodymyr.groupexpense.expense.domain.dto;

import lombok.Getter;

@Getter
public class UpdateExpenseInGroupExpense {

    private GetGroupExpenseDTO groupExpenseDTO;
    private CreateExpenseDTO expenseDTO;
}
