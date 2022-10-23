package volodymyr.groupexpense.expense.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import volodymyr.groupexpense.expense.domain.value_object.ExpenseDescription;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
@SuperBuilder
@EqualsAndHashCode
public class Expense {

    private Payer payer;
    private ExpenseDescription expenseDescription;
    private LocalDateTime createTime;

    private Expense(Payer payer, ExpenseDescription description){
        this.payer = payer;
        this.expenseDescription = description;
        this.createTime = LocalDateTime.now();
    }

    public static Expense createExpense(Payer payer, ExpenseDescription description){
        return new Expense(payer, description);
    }

}
