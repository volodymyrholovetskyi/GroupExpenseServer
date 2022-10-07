package volodymyr.groupexpense.expense.domain;

import lombok.Builder;
import lombok.Getter;
import volodymyr.groupexpense.expense.domain.vo.ExpenseName;
import volodymyr.groupexpense.expense.domain.vo.Payer;

import java.time.LocalDateTime;

@Builder
@Getter
public class Expense {

    private Payer payer;
    private ExpenseName expenseName;
    private LocalDateTime createTime;

}
