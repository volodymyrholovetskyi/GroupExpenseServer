package volodymyr.groupexpense.expense.domain.repo;

import volodymyr.groupexpense.expense.domain.GroupExpense;

public interface ExpenseRepository {

    GroupExpense createGroup(GroupExpense groupExpense);

}
