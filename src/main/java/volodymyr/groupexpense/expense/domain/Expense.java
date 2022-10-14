package volodymyr.groupexpense.expense.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import volodymyr.groupexpense.expense.domain.vo.ExpenseDescription;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
class Expense {

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
