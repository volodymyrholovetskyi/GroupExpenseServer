package volodymyr.groupexpense.expense.domain.dto.incoming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateGroupExpenseDTO {

    public String name;
}
