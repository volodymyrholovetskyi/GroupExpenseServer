package volodymyr.groupexpense.expense.infrastructure.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import volodymyr.groupexpense.jpa.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Entity
@Table(name = "expense")
public
class ExpenseEntity extends BaseEntity {

    private String description;

    @Embedded
    private PayerEmbedded payer;

    private LocalDateTime createTime;

}
