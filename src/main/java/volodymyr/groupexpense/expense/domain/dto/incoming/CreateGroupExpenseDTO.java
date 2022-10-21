package volodymyr.groupexpense.expense.domain.dto.incoming;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateGroupExpenseDTO {

    public String name;
}
