package volodymyr.groupexpense.expense.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import volodymyr.groupexpense.expense.domain.dto.outcoming.GetGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.mapper.GroupExpenseMapper;
import volodymyr.groupexpense.expense.domain.repo.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExpenseQueryService {

    private final ExpenseRepository expenseRepository;
    public List<GetGroupExpenseDTO> findByNameGroup(String name) {
        //TODO DOPISZ !!!
        return null;
    }


    public List<GetGroupExpenseDTO> getAllGroup() {
        return expenseRepository
                .findAll()
                .stream()
                .map(GroupExpenseMapper::toGetGroupExpenseDTO)
                .toList();
    }

    public Optional<GetGroupExpenseDTO> getGroupById(Long id) {
        return expenseRepository
                .findById(id)
                .stream()
                .map(GroupExpenseMapper::toGetGroupExpenseDTO)
                .findFirst();
    }
}
