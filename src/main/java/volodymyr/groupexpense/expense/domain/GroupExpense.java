package volodymyr.groupexpense.expense.domain;

import lombok.Builder;
import volodymyr.groupexpense.expense.domain.dto.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

import java.time.LocalDateTime;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.*;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.*;

//AggregateRoot

@Builder
public class GroupExpense {

    protected Long id;

    protected GroupName name;

    protected Status status;

    protected LocalDateTime createTime;

    protected LocalDateTime updateTime;

    protected Set<Expense> expenses;

    protected GroupExpense(String name, LocalDateTime createTime) {
        this.name = createName(name);
        status = IN_PROGRESS;
        this.createTime = createTime;
    }

//    protected GroupExpense() {
//        this.name = createName(name);
//        status = IN_PROGRESS;
//        this.createTime = createTime;
//    }

    public static GroupExpense createNewGroupExpense(CreateGroupExpenseDTO expenseDTO){
        return GroupExpense.builder()
                .name(createName(expenseDTO.getName()))
                .createTime(LocalDateTime.now())
                .build();
    }


    public static GroupExpense addExpenseToGroupExpense(CreateExpenseDTO expenseDTO){
        return GroupExpense.builder()
                .expenses.add(expenseDTO.)
                //TODO DOROB!!!
                .build();
    }


}
