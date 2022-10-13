package volodymyr.groupexpense.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static volodymyr.groupexpense.expense.domain.vo.GroupName.groupName;

class ExpenseFacadeTest extends ExpenseTestBase {

    private ExpenseFacade facade;

    @BeforeEach
    void setUp() {
        facade = new ExpenseFacade();
    }

    @Test
    void should_return_new_group_expense() {
        //given
        //then
        GroupExpense newGroupExpense = facade.createNewGroupExpense(tripToMountains());
        //when
        assertThat(newGroupExpense.name).isEqualTo(groupName("Trip to the mountains"));
    }

    @Test
    void should_return_expense_added_to_group() {
        //given

        //then
        GroupExpense groupExpense = facade.addExpenseToGroupExpense(coffee());
        //when
        assertThat(groupExpense.getExpenses())
                .hasSize(1);
    }

}