package org.example.backendspring.controller;
import org.example.backendspring.entity.budget;
import org.example.backendspring.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budget")
public class budgetController {
    private final BudgetService service;
    @Autowired
    public budgetController(final BudgetService service){
        this.service=service;
    }

    @PostMapping("/Add")
    public String saveBudget(@RequestBody budget budget){

        service.saveBudget(budget);
        return ("budget added successfully");
    }
    @GetMapping("/{id}")
    public budget getBudget(@PathVariable long id){
        return service.getBudgetByID(id);
    }
    @GetMapping("/All")
    public List<budget> getBudgets(){
        return service.getBudgets();
    }

   @DeleteMapping("/{id}")
    public String deleteBudget(@PathVariable long id){
        service.deletBudgetBYId(id);
        return "budget deleted";
   }
    @PutMapping("/update/{id}")
    public Optional<budget> updateProduct(@PathVariable long id, @RequestBody budget bg) {
        return service.updatesBudget(id,bg);
    }

}
