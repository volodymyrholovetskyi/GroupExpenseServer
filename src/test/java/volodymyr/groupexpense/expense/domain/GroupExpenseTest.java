package volodymyr.groupexpense.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupExpenseTest {

    GroupExpense groupExpense;
    @BeforeEach
    void setUp() {
        groupExpense = new GroupExpense();
    }


}