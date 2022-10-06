package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.dto.GroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

import java.time.LocalDateTime;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.*;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.*;

public class GroupExpense {

    protected Long id;

    protected GroupName name;

    protected Status status;

    protected LocalDateTime createTime;

    protected LocalDateTime updateTime;

    protected Set<Participant> participants;

    public GroupExpense(){
    }
    protected GroupExpense(String name, LocalDateTime createTime) {
        this.name = createName(name);
        status = IN_PROGRESS;
        this.createTime = createTime;
    }

    public static GroupExpense createNewGroupExpense(GroupExpenseDTO expenseDTO){
        return new GroupExpense(expenseDTO.getName(), LocalDateTime.now());
    }




}
