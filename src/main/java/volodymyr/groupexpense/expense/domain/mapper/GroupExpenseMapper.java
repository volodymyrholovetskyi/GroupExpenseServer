package volodymyr.groupexpense.expense.domain.mapper;

import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.dto.outcoming.GetGroupExpenseDTO;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.GroupExpenseEntity;

import static volodymyr.groupexpense.expense.domain.mapper.ExpenseMapper.toExpenses;
import static volodymyr.groupexpense.expense.domain.type.Status.verificationType;
import static volodymyr.groupexpense.expense.domain.value_object.GroupDescription.ofName;

public class GroupExpenseMapper {

//    public static GroupExpense toGroupExpenses

    public static GroupExpense toGroupExpense(GroupExpenseEntity groupEntity) {
        return GroupExpense
                .builder()
                .idGroup(groupEntity.getId())
                .groupDescription(ofName(groupEntity.getName()))
                .status(verificationType(groupEntity.getStatus()))
                .expenses(toExpenses(groupEntity.getExpenses()))
                .build();
    }

    public static GetGroupExpenseDTO toGetGroupExpenseDTO(GroupExpense groupExpense) {
        return GetGroupExpenseDTO
                .builder()
                .id(groupExpense.getIdGroup())
                .name(groupExpense.getGroupDescription().getGroupDescription())
                .status(groupExpense.getStatus().toString())
                .expenseDTO(ExpenseMapper.toGetExpenseDTOS(groupExpense.getExpenses()))
                .build();
    }

}
