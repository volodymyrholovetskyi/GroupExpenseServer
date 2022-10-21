package volodymyr.groupexpense.expense.domain.dto.outcoming;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class GetGroupExpenseDTO {

    private Long id;

    private String name;

    private String status;

    private Set<GetExpenseDTO> expenseDTO;
}
