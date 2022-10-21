package volodymyr.groupexpense.expense.infrastructure.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.GroupExpenseEntity;

import java.util.Optional;

public interface ExpenseRepositoryDAO extends JpaRepository<GroupExpenseEntity, Long> {

    GroupExpenseEntity save(GroupExpenseEntity expense);

    GroupExpenseEntity getById(Long id);
}
