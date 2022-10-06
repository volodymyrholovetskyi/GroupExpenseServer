package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.vo.ExpesneName;
import volodymyr.groupexpense.expense.domain.vo.Payer;

import java.time.LocalDateTime;

public class Expense {

    protected Payer payer;
    protected ExpesneName expenseName;
    protected LocalDateTime createTime;

}
