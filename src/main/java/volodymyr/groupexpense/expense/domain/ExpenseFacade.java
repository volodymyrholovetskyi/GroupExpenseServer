package volodymyr.groupexpense.expense.domain;

import lombok.NoArgsConstructor;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.value_object.FullNamePayer;

import static volodymyr.groupexpense.expense.domain.model.Expense.createExpense;
import static volodymyr.groupexpense.expense.domain.model.GroupExpense.createNewGroup;
import static volodymyr.groupexpense.expense.domain.value_object.ExpenseDescription.ofDescription;
import static volodymyr.groupexpense.expense.domain.value_object.GroupDescription.ofName;
import static volodymyr.groupexpense.expense.domain.model.Payer.createPayer;
import static volodymyr.groupexpense.expense.domain.value_object.Payment.ofPayment;

@NoArgsConstructor
public class ExpenseFacade {

    public GroupExpense createGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        return createNewGroup(ofName(expenseDTO.name));
    }

    public GroupExpense addExpenseToGroup(Long idGroup, CreateExpenseDTO expenseDTO) {
        var payer = createPayer(
                FullNamePayer.ofFullName(expenseDTO.firstName(), expenseDTO.lastName()),
                ofPayment(expenseDTO.payment(), expenseDTO.currency())
        );

        var expense = createExpense(payer, ofDescription(expenseDTO.description()));
        return GroupExpense.addExpenseToGroup(idGroup, expense);
    }
}
