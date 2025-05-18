package org.example.backendspring.service;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.budget;
import org.example.backendspring.mapper.BudgetMapper;
import org.example.backendspring.repository.budgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final budgetRepository repository;
     @Autowired
     public BudgetService(final budgetRepository repository){

         this.repository = repository;
     }

    public  void saveBudget (budget budget){
      repository.save(budget);

    }

     public BudgetDto getBudgetByID(long id){
            Optional<budget> budg = this.repository.findById(id);
            if(budg.isPresent()){
                return BudgetMapper.toDto(budg.get());
            }
        return null;
     }

     public void  deletBudgetBYId(long id){
        repository.deleteById(id);

     }

    public List<budget> getBudgets() {
        return repository.findAll();
    }
    public Optional<budget> updatesBudget(long id,budget bg) {
        return repository.findById(id)
                .map(budget -> {
                    budget.setMontant(bg.getMontant());
                    budget.setEnum(bg.getenumValue());
                    budget.setDate(bg.getDate());
                    return repository.save(budget);
                });

    }

}
