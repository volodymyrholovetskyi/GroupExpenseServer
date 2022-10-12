package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.UpdateExpenseInGroupExpense;
import volodymyr.groupexpense.expense.domain.vo.*;

import static volodymyr.groupexpense.expense.domain.GroupExpense.*;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.*;

public class ExpenseFacade {

    public GroupExpense createNewGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        return createNewGroup(groupName(expenseDTO.name));
    }

    public GroupExpense addExpenseToGroupExpense(UpdateExpenseInGroupExpense groupExpense) {
        var expenseName = new ExpenseName(groupExpense.expenseName());
        var payment = new Payment(groupExpense.payment(), groupExpense.currency());
        var payer = new Payer(new NamePayer(groupExpense.firstName(), groupExpense.lastName()), payment);
        var expense = Expense.builder().expenseName(expenseName).payer(payer).build();

        return addExpense(expense);
    }
}
