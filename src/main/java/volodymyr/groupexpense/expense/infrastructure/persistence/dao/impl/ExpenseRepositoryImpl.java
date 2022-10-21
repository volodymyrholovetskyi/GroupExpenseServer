package volodymyr.groupexpense.expense.infrastructure.persistence.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.mapper.GroupExpenseMapper;
import volodymyr.groupexpense.expense.domain.repo.ExpenseRepository;
import volodymyr.groupexpense.expense.infrastructure.persistence.dao.ExpenseRepositoryDAO;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.GroupExpenseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static volodymyr.groupexpense.expense.domain.mapper.GroupExpenseMapper.*;

@Repository
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseRepositoryDAO repositoryDAO;

    @Override
    public GroupExpense save(GroupExpense groupExpense) {
        var newGroup = repositoryDAO.save(groupExpense.toGroupExpenseEntity());
        var groupEntity = repositoryDAO.save(newGroup);
        return toGroupExpense(groupEntity);
    }

    @Override
    public Set<GroupExpense> findAll() {
        List<GroupExpenseEntity> allGroup = repositoryDAO.findAll();
        return allGroup
                .stream()
                .map(GroupExpenseMapper::toGroupExpense)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<GroupExpense> findById(Long id) {
       return repositoryDAO.findById(id)
                .stream()
                .map(GroupExpenseMapper::toGroupExpense)
                .findFirst();
    }
}
