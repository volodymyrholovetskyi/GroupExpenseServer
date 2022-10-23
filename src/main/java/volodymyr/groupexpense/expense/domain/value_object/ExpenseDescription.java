package volodymyr.groupexpense.expense.domain.value_object;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ExpenseDescription {

    private String description;

    private ExpenseDescription(String description){
        this.description = description;
    }

    public static ExpenseDescription ofDescription(String description){
        return new ExpenseDescription(description);
    }
}
