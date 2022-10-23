package volodymyr.groupexpense.expense.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.value_object.GroupDescription;
import volodymyr.groupexpense.expense.infrastructure.persistence.entity.GroupExpenseEntity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.IN_PROGRESS;

//AggregateRoot

@Getter
@ToString
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class GroupExpense {

    protected Long idGroup;

    protected GroupDescription groupDescription;

    protected Status status;

    protected LocalDateTime createTime;

    protected Set<Expense> expenses = new HashSet<>();


    private GroupExpense(GroupDescription groupDescription) {
        this.groupDescription = groupDescription;
        this.status = IN_PROGRESS;
        this.createTime = LocalDateTime.now();
    }

    private GroupExpense(Long idGroup, Expense expense) {
        this.idGroup = idGroup;
        this.expenses = Set.of(expense);
    }

    public static GroupExpense createNewGroup(GroupDescription description) {
        return new GroupExpense(description);
    }

    public static GroupExpense addExpenseToGroup(Long idGroup, Expense expense) {
        return new GroupExpense(idGroup, expense);
    }

    public GroupExpenseEntity toGroupExpenseEntity() {
        return GroupExpenseEntity
                .builder()
                .description(groupDescription.getGroupDescription())
                .status(status.toString())
                .createTime(createTime)
                .build();
    }

}
