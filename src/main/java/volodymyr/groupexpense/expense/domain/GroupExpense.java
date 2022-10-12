package volodymyr.groupexpense.expense.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

import java.time.LocalDateTime;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.IN_PROGRESS;

//AggregateRoot

@Getter
@ToString
@Builder
class GroupExpense {

    protected Long id;

    protected GroupName name;
    protected Status status;

    protected LocalDateTime createTime;

    protected Set<Expense> expenses;

//    private GroupExpense(String name){
//        this.name = GroupName.createName(name);
//        this.createTime = LocalDateTime.now();
//        this.status = IN_PROGRESS;
//    }

    static GroupExpense createNewGroup(GroupName name){
        return GroupExpense.builder()
                .name(name)
                .status(IN_PROGRESS)
                .createTime(LocalDateTime.now())
                .build();
    }

    static GroupExpense addExpense(Expense expense) {
        return GroupExpense.builder().expenses(Set.of(expense)).build();
    }

}
