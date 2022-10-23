package volodymyr.groupexpense.expense.domain.dto.outcoming;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class GetExpenseDTO {

    private String description;

    private BigDecimal payer;

    private LocalDateTime createTime;
}
