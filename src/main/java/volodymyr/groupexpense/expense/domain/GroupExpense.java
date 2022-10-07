package volodymyr.groupexpense.expense.domain;

import lombok.Builder;
import volodymyr.groupexpense.expense.domain.dto.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.UpdateExpenseInGroupExpense;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.*;

import java.time.LocalDateTime;
import java.util.Set;

import static volodymyr.groupexpense.expense.domain.type.Status.IN_PROGRESS;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.createName;

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

    public static GroupExpense createNewGroupExpense(CreateGroupExpenseDTO expenseDTO) {
        return GroupExpense.builder()
                .name(createName(expenseDTO.getName()))
                .createTime(LocalDateTime.now())
                .build();
    }


    public static GroupExpense addExpenseToGroupExpense(UpdateExpenseInGroupExpense groupExpense) {
        var expenseName = new ExpenseName(groupExpense.getExpenseDTO().getExpenseName());
        var payment = new Payment(groupExpense.getExpenseDTO().getPayment(),
                groupExpense.getExpenseDTO().getCurrency());
        var payer = new Payer(new NamePayer(groupExpense.getExpenseDTO().getFirstName(),
                groupExpense.getExpenseDTO().getLastName()), payment);
        var expense = Expense.builder().expenseName(expenseName).payer(payer).build();

        return GroupExpense
                .builder()
                .id(groupExpense.getGroupExpenseDTO().getId())
                .name(groupExpense.getGroupExpenseDTO().getName())
                .expenses(Set.of(expense))
                .build();
    }
}
