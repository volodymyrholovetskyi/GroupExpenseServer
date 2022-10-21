package volodymyr.groupexpense.expense.domain.repo;

import volodymyr.groupexpense.expense.domain.model.GroupExpense;

import java.util.Optional;
import java.util.Set;

public interface ExpenseRepository {

    GroupExpense save(GroupExpense groupExpense);

    Set<GroupExpense> findAll();

    Optional<GroupExpense> findById(Long id);
}
