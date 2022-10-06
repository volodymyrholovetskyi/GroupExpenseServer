package volodymyr.groupexpense.expense.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateGroupExpenseDTO {

    private String name;
}
