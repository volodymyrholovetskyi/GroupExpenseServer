package volodymyr.groupexpense.expense.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import volodymyr.groupexpense.expense.domain.ExpenseFacade;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseFacade facade;

    public ExpenseService(){
        facade = new ExpenseFacade();
    }

    public void createNewGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        facade.createNewGroupExpense(expenseDTO);
    }


}
