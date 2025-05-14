package org.example.backendspring.controller;


import org.example.backendspring.entity.Transaction;
import org.example.backendspring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transaction;


    @PostMapping
    public Transaction ajouter(@RequestBody Transaction t) {
        return transaction.ajouterTransaction(t);
    }

    }
