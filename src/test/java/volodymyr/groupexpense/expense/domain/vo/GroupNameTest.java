package volodymyr.groupexpense.expense.domain.vo;

import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.GroupExpense;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupNameTest {

    @Test
    void should_return_exception_if_the_group_name_less_than_3_letters() {
        //given
        //when
        //then
        assertThrows(InvalidGroupNameException.class, () -> GroupName.createName("tr"));
//        assertThatThrownBy(IllegalArgumentException::new).
//                .hasMessage("At least 3 letters");
//        assertThatThrownBy()
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("At least 3 letters");
//    }
    }



        @Test
        void is_should_return_group_name(){
            //given
            GroupName trip = GroupName.createName("trip");
            //when
            //then
            assertThat(trip.getName()).isEqualTo("trip");
        }
}