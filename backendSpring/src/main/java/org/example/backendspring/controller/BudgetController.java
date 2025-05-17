package org.example.backendspring.controller;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.Budget;
import org.example.backendspring.entity.Transaction;
import org.example.backendspring.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetService service;

    @Autowired
    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @PostMapping
    public Budget saveBudget(@RequestBody Budget budget) {
        return service.saveBudget(budget);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDto> getBudget(@PathVariable long id) {
        BudgetDto budget = service.getBudgetByID(id);
        return ResponseEntity.ok(budget);
    }

    @GetMapping
    public List<Budget> getBudgets() {
        return service.getBudgets();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable long id) {
        boolean deleted = service.deleteBudgetById(id);
        if (deleted) {
            return ResponseEntity.ok("Budget deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Optional<Budget>> updateBudget(@PathVariable long id, @RequestBody Budget budget) {
        return ResponseEntity.ok(service.updatesBudget(id, budget));
    }
}
