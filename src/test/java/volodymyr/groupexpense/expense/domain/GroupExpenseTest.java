package volodymyr.groupexpense.expense.domain;

import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.dto.GroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupExpenseTest {

    @Test
    void should_return_new_group_expense() {
        //given
        GroupExpenseDTO expenseDTO = GroupExpenseDTO
                .builder()
                .name("trip")
                .build();
        //then
        GroupExpense newGroupExpense = GroupExpense.createNewGroupExpense(expenseDTO);
        //when
        assertThat(newGroupExpense.name.getName()).isEqualTo("trip");
    }

    @Test
    void exception_should_be_thrown_if_the_group_name_is_null() {
        //given
        //when
        //then
        assertThrows(InvalidGroupNameException.class, () -> new GroupExpense(null, LocalDateTime.now()));
    }
}