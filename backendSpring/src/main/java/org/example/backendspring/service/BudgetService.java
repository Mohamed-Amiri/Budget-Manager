package org.example.backendspring.service;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.Budget;
import org.example.backendspring.mapper.BudgetMapper;
import org.example.backendspring.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    private final BudgetRepository repository;

    @Autowired
    public BudgetService(BudgetRepository repository) {
        this.repository = repository;
    }

    public Budget saveBudget(Budget budget) {
      return   repository.save(budget);
    }

    public BudgetDto getBudgetByID(long id) {
        return repository.findById(id)
                .map(BudgetMapper::toDto)
                .orElse(null);
    }

    public boolean deleteBudgetById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Budget> getBudgets() {
        return repository.findAll();
    }

    public Optional<Budget> updatesBudget(long id, Budget updatedBudget) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMontant(updatedBudget.getMontant());
                    existing.setEnum(updatedBudget.getEnum());
                    existing.setDate(updatedBudget.getDate());
                    return repository.save(existing);
                });
    }
}
