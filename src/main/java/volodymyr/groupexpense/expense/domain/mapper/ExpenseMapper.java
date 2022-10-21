package volodymyr.groupexpense.expense.domain.mapper;

import volodymyr.groupexpense.expense.domain.model.Expense;
import volodymyr.groupexpense.expense.domain.model.Payer;
import volodymyr.groupexpense.expense.domain.dto.outcoming.GetExpenseDTO;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.ExpenseEntity;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.PayerEmbedded;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static volodymyr.groupexpense.expense.domain.value_object.FullNamePayer.*;
import static volodymyr.groupexpense.expense.domain.value_object.Payment.*;

class ExpenseMapper {

    public static Set<Expense> toExpenses(Set<ExpenseEntity> expenses){
        if (expenses != null) {
            return expenses
                    .stream()
                    .map(ExpenseMapper::toExpense)
                    .collect(Collectors.toSet());
        }
        return emptySet();
    }

    private static Expense toExpense(ExpenseEntity expenseEntity){
        return Expense
                .builder()
                .payer(toPayer(expenseEntity.getPayer()))
                .build();
    }

     private static Payer toPayer(PayerEmbedded payer) {
         return Payer
                 .builder()
                 .name(ofFullName(payer.getFirstName(), payer.getLastName()))
                 .payment(ofPayment(payer.getPayment(), payer.getCurrency()))
                 .build();
     }

    public static Set<GetExpenseDTO> toGetExpenseDTOS(Set<Expense> expense) {
        return expense
                .stream()
                .map(ExpenseMapper::toGetExpenseDTO)
                .collect(Collectors.toSet());
    }

    private static GetExpenseDTO toGetExpenseDTO(Expense expense) {
        return GetExpenseDTO
                .builder()
                .description(expense.getExpenseDescription().toString())
                .createTime(expense.getCreateTime())
                .payer(new BigDecimal(expense.getPayer().toString()))
                .build();
    }
 }
