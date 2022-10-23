package volodymyr.groupexpense.expense.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.repo.ExpenseRepository;
import volodymyr.groupexpense.expense.domain.value_object.FullNamePayer;
import volodymyr.groupexpense.expense.infrastructure.persistence.dao.impl.ExpenseRepositoryImpl;

import static volodymyr.groupexpense.expense.domain.model.Expense.createExpense;
import static volodymyr.groupexpense.expense.domain.model.GroupExpense.createNewGroup;
import static volodymyr.groupexpense.expense.domain.value_object.ExpenseDescription.ofDescription;
import static volodymyr.groupexpense.expense.domain.value_object.GroupDescription.ofName;
import static volodymyr.groupexpense.expense.domain.model.Payer.createPayer;
import static volodymyr.groupexpense.expense.domain.value_object.Payment.ofPayment;

public class ExpenseFacade {

    private final ExpenseRepository repository;

    public ExpenseFacade(){
        this.repository = new ExpenseRepositoryImpl();
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        System.out.println(expenseDTO.description);
        return createNewGroup(ofName(expenseDTO.description));
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
