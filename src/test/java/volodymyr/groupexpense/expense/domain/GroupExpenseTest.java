package volodymyr.groupexpense.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static volodymyr.groupexpense.expense.domain.type.Status.*;

class GroupExpenseTest {

    GroupExpense groupExpense;
    @BeforeEach
    void setUp() {
        groupExpense = new GroupExpense();
    }


}