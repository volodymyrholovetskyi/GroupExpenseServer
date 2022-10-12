package volodymyr.groupexpense.expense.domain.vo;

import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.groupName;

class GroupNameTest {


    @Test
    void should_return_exception_if_the_group_name_less_than_3_letters() {
        //given
        //when
        //then
        assertThatThrownBy(() -> groupName("t"))
                .isInstanceOf(InvalidGroupNameException.class)
                .hasMessage("Group name is invalid: t");
    }

    @Test
    void exception_should_be_thrown_if_the_group_name_is_null() {
        //given
        //when
        //then
        assertThatThrownBy(() -> groupName(null))
                .isInstanceOf(InvalidGroupNameException.class)
                .hasMessage("Group name is invalid: null");
    }

    @Test
    void is_should_return_group_name() {
        //given
        GroupName trip = groupName("trip");
        //when
        //then
        assertThat(trip.getName()).isEqualTo("trip");
    }
}