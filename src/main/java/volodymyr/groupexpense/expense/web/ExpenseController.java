package volodymyr.groupexpense.expense.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volodymyr.groupexpense.common.HATEOAS.CreatedURI;
import volodymyr.groupexpense.expense.application.ExpenseCommandService;
import volodymyr.groupexpense.expense.application.ExpenseQueryService;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.incoming.CreateGroupExpenseDTO;
import volodymyr.groupexpense.expense.domain.dto.outcoming.GetGroupExpenseDTO;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;


@RestController
@AllArgsConstructor
@RequestMapping("expenses")
public class ExpenseController {

    private final ExpenseCommandService expenseCommandService;
    private final ExpenseQueryService queryService;


    @GetMapping
    @ResponseStatus(OK)
    List<GetGroupExpenseDTO> getAllGroup(@RequestParam Optional<String> name) {
        if (name.isPresent()){
            return queryService.findByNameGroup(name.get());
        }
        return queryService.getAllGroup();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getGroupById(@PathVariable("id") Long id){
        return queryService
                .getGroupById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping()
    ResponseEntity<Void> createGroup(@RequestBody CreateGroupExpenseDTO expenseDTO) {
        GetGroupExpenseDTO groupExpense = expenseCommandService.createNewGroupExpense(expenseDTO);
        CreatedURI uri = new CreatedURI("/" + groupExpense.getId().toString());
        return ResponseEntity.created(uri.createdURI()).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    void addExpenseToGroup(@PathVariable("id") Long id, @RequestBody CreateExpenseDTO expenseDTO){
        expenseCommandService.addExpenseToGroup(id, expenseDTO);
    }
}
