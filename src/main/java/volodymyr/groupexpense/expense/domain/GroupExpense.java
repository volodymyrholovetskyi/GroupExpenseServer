package volodymyr.groupexpense.expense.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.IN_PROGRESS;

//AggregateRoot

@Getter
@ToString
@NoArgsConstructor
public class GroupExpense {

    protected Long id;

    protected GroupName name;

    protected Status status;

    protected LocalDateTime createTime;

    protected Set<Expense> expenses = new HashSet<>();


    private GroupExpense(GroupName name){
        this.name = name;
        this.status = IN_PROGRESS;
        this.createTime = LocalDateTime.now();
    }

    private GroupExpense(Expense expense){
    this.expenses = Set.of(expense);
}

    static GroupExpense createNewGroup(GroupName name) {
        return new GroupExpense(name);
    }

    static GroupExpense addExpenseToGroup(Expense expense) {
        return new GroupExpense(expense);
    }
}
