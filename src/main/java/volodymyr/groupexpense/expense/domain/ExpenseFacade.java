package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;

import static volodymyr.groupexpense.expense.domain.Expense.createExpense;
import static volodymyr.groupexpense.expense.domain.GroupExpense.addExpenseToGroup;
import static volodymyr.groupexpense.expense.domain.GroupExpense.createNewGroup;
import static volodymyr.groupexpense.expense.domain.vo.ExpenseDescription.expenseDescription;
import static volodymyr.groupexpense.expense.domain.vo.FullNamePayer.createParticipantName;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.groupName;
import static volodymyr.groupexpense.expense.domain.vo.Payer.createPayer;
import static volodymyr.groupexpense.expense.domain.vo.Payment.createPayment;

public class ExpenseFacade {

    public GroupExpense createNewGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        return createNewGroup(groupName(expenseDTO.name));
    }

    public GroupExpense addExpenseToGroupExpense(CreateExpenseDTO expenseDTO) {
        var payer = createPayer(
                createParticipantName(expenseDTO.firstName(), expenseDTO.lastName()),
                createPayment(expenseDTO.payment(), expenseDTO.currency())
        );

        var expense = createExpense(payer, expenseDescription(expenseDTO.description()));
        return addExpenseToGroup(expense);
    }
}
