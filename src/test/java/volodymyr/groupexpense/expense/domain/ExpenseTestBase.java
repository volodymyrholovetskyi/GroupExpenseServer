package volodymyr.groupexpense.expense.domain;

import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.model.Expense;
import volodymyr.groupexpense.expense.domain.model.GroupExpense;
import volodymyr.groupexpense.expense.domain.model.Payer;
import volodymyr.groupexpense.expense.domain.value_object.ExpenseDescription;
import volodymyr.groupexpense.expense.domain.value_object.FullNamePayer;
import volodymyr.groupexpense.expense.domain.value_object.GroupDescription;
import volodymyr.groupexpense.expense.domain.value_object.Payment;

import java.math.BigDecimal;

import static volodymyr.groupexpense.expense.domain.model.Payer.createPayer;

public abstract class ExpenseTestBase {

    public CreateGroupExpenseDTO tripToMountains() {
        return new CreateGroupExpenseDTO("Trip to the mountains");
    }

    public GroupExpense groupTripToMountains(){
        return GroupExpense.createNewGroup(
                GroupDescription.ofName("Trip to the mountains")
        );
    }

   public CreateGroupExpenseDTO groupDescriptionWithTwoLiter(){
        return new CreateGroupExpenseDTO("tr");
   }


    public CreateExpenseDTO coffeeActual() {
        return new CreateExpenseDTO(
                "coffee",
                "Volodymyr",
                "Holovetskyi",
                BigDecimal.valueOf(12),
                "PLN"
        );
    }

    public CreateExpenseDTO negativePayment() {
        return new CreateExpenseDTO(
                "coffee",
                "Volodymyr",
                "Holovetskyi",
                BigDecimal.valueOf(-12),
                "PLN"
        );
    }

    public Expense coffeeExpected(){
        Payer payer = createPayer(
                FullNamePayer.ofFullName("Volodymyr", "Holovetskyi"),
                Payment.ofPayment(BigDecimal.valueOf(12), "PLN")
        );
        ExpenseDescription coffee = ExpenseDescription.ofDescription("coffee");
        return Expense.createExpense(payer, coffee);
    }
}