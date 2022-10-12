package volodymyr.groupexpense.expense.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import volodymyr.groupexpense.expense.domain.ExpenseFacade;
import volodymyr.groupexpense.expense.domain.GroupExpense;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    public final ExpenseFacade facade;

    public ExpenseService(){
        facade = new ExpenseFacade();
    }

    public void createGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        facade.addExpenseToGroupExpense(expenseDTO);
    }
}
