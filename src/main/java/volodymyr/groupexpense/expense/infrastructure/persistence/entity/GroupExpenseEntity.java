package volodymyr.groupexpense.expense.infrastructure.persistence.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import volodymyr.groupexpense.jpa.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//AggregateRoot

@Getter
@ToString
@Entity
@SuperBuilder
@Table(name = "group_expense")
public class GroupExpenseEntity extends BaseEntity {

    private String description;

    private String status;

    private LocalDateTime createTime;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_group")
    @Fetch(FetchMode.SUBSELECT)
    private Set<ExpenseEntity> expenses = new HashSet<>();

    public GroupExpenseEntity() {
    }
}

