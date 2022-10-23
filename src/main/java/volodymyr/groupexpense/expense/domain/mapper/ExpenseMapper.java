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

    protected static ExpenseEntity toExpenseEntity(Expense expense){
        return ExpenseEntity
                .builder()
                .createTime(expense.getCreateTime())
                .description(expense.getExpenseDescription().toString())
                .payer(toPayerEmbedded(expense.getPayer()))
                .build();
    }

    private static PayerEmbedded toPayerEmbedded(Payer payer){
        return PayerEmbedded
                .builder()
                .name(payer.getName().fullName())
                .payment(payer.getPayment().getPayment())
                .currency(payer.getPayment().getCurrency().toString())
                .build();
    }

     private static Payer toPayer(PayerEmbedded payer) {
         String[] fullName = payer.getName().split(" ");
         return Payer
                 .builder()
                 .name(ofFullName(fullName[0], fullName[0]))
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
