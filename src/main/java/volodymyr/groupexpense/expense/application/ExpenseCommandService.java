package volodymyr.groupexpense.expense.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import volodymyr.groupexpense.expense.domain.ExpenseFacade;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.outcoming.GetGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.repo.ExpenseRepository;

import static volodymyr.groupexpense.expense.domain.mapper.GroupExpenseMapper.*;

@Service
@Slf4j
public class ExpenseCommandService {

    private final ExpenseFacade facade;

    private final ExpenseRepository repository;

    public ExpenseCommandService(ExpenseRepository repository){
        facade = new ExpenseFacade();
        this.repository = repository;
    }

    public GetGroupExpenseDTO createNewGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        var newGroup = facade.createGroupExpense(expenseDTO);
        GroupExpense groupExpense = repository.save(newGroup);
        return toGetGroupExpenseDTO(groupExpense);
    }


    public void addExpenseToGroup(Long idGroup, CreateExpenseDTO expenseDTO) {
        repository.findById(idGroup)
                .map(g -> {
                    GroupExpense expense = facade.addExpenseToGroup(idGroup, expenseDTO);
                   return repository.save(expense);
                })
                .orElseThrow(() -> new IllegalArgumentException("Not found Group with id: %s".formatted(idGroup)));
    }
}
