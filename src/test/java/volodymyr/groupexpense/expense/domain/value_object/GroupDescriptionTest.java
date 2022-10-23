package volodymyr.groupexpense.expense.domain.value_object;

import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupDescriptionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static volodymyr.groupexpense.expense.domain.value_object.GroupDescription.ofName;

class GroupDescriptionTest {


    @Test
    void should_return_exception_if_the_group_name_less_than_3_letters() {
        //given
        //when
        //then
        assertThatThrownBy(() -> ofName("t"))
                .isInstanceOf(InvalidGroupDescriptionException.class)
                .hasMessage("Group name is invalid: t");
    }

    @Test
    void exception_should_be_thrown_if_the_group_name_is_null() {
        //given
        //when
        //then
        assertThatThrownBy(() -> ofName(null))
                .isInstanceOf(InvalidGroupDescriptionException.class)
                .hasMessage("Group name is invalid: null");
    }

    @Test
    void is_should_return_group_name() {
        //given
        GroupDescription trip = ofName("trip");
        //when
        //then
        assertThat(trip.getGroupDescription()).isEqualTo("trip");
    }
}