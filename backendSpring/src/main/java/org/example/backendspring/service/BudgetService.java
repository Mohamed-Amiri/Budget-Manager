package org.example.backendspring.service;

import org.example.backendspring.entity.budget;
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


}
