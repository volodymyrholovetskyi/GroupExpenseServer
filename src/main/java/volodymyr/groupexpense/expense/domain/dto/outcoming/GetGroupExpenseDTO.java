package volodymyr.groupexpense.expense.domain.dto.outcoming;

import lombok.Getter;
import volodymyr.groupexpense.expense.domain.vo.GroupName;

@Getter
public class GetGroupExpenseDTO {

    private Long id;

    private GroupName name;

    private String status;
}
