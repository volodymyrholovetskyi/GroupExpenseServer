package volodymyr.groupexpense.expense.domain.vo;

public class ExpenseDescription {

    private String description;

    private ExpenseDescription(String description){
        this.description = description;
    }

    public static ExpenseDescription expenseDescription(String description){
        return new ExpenseDescription(description);
    }
}
