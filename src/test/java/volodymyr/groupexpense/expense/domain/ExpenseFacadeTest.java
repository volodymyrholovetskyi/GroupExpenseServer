package volodymyr.groupexpense.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupDescriptionException;
import volodymyr.groupexpense.expense.domain.exceptions.MoneyInvalidAmountException;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.value_object.Payment;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpenseFacadeTest extends ExpenseTestBase {

    private ExpenseFacade facade;

    @BeforeEach
    void setUp() {
        facade = new ExpenseFacade();
    }

    @Test
    void should_return_new_group_expense() {
        //given
        GroupExpense expected = groupTripToMountains();
        //then
        GroupExpense actual = facade.createGroupExpense(tripToMountains());
        //when
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void when_description_length_is_less_than_3_letters_return_exception() {
        //given
        CreateGroupExpenseDTO group = groupDescriptionWithTwoLiter();
        //then
        //when
        assertThatThrownBy(() -> facade.createGroupExpense(group))
                .isInstanceOf(InvalidGroupDescriptionException.class)
                .hasMessage("Incorrect name: tr");
    }

    @Test
    void when_description_is_null_return_exception() {
        //given
        CreateGroupExpenseDTO group = CreateGroupExpenseDTO.builder()
                .description(null)
                .build();
        //then
        //when
        assertThatThrownBy(() -> facade.createGroupExpense(group))
                .isInstanceOf(InvalidGroupDescriptionException.class)
                .hasMessage("Incorrect name: null");
    }

    @Test
    void should_return_expense_added_to_group() {
        //given
        CreateExpenseDTO coffeeActual = coffeeActual();
        //then
        GroupExpense groupExpense = facade.addExpenseToGroup(1L, coffeeActual);
        //when
        assertThat(groupExpense.getExpenses())
                .isNotEmpty()
                .hasSize(1)
                .extracting(g -> g.getPayer().getPayment())
                .containsOnly(Payment.ofPayment(BigDecimal.valueOf(12), "PLN"));
    }

    @Test
    void should_return_exception_if_payment_is_negative() {
        //given
        CreateExpenseDTO negativePayment = negativePayment();
        //then
        //when
        assertThatThrownBy(() -> facade.addExpenseToGroup(1L, negativePayment))
                .isInstanceOf(MoneyInvalidAmountException.class);
    }

}