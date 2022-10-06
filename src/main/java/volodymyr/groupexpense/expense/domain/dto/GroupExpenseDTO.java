package volodymyr.groupexpense.expense.domain.dto;

import lombok.Builder;
import lombok.Getter;
import volodymyr.groupexpense.expense.domain.type.Status;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

import java.time.LocalDateTime;

@Getter
@Builder
public class GroupExpenseDTO {

    private String name;
}
