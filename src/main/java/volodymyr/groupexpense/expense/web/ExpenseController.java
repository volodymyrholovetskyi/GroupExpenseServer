package volodymyr.groupexpense.expense.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volodymyr.groupexpense.expense.application.ExpenseService;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;


@RestController
@AllArgsConstructor
@RequestMapping("expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping()
    void create(@RequestBody CreateGroupExpenseDTO expenseDTO) {
        System.out.println(expenseDTO.toString());
        expenseService.createGroupExpense(expenseDTO);
    }
}
