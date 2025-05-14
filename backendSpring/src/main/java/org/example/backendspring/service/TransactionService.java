package org.example.backendspring.service;

import org.example.backendspring.entity.Transaction;
import org.example.backendspring.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

     final TransactionRepository transaction;

     @Autowired
    public TransactionService(TransactionRepository transaction) {
         this.transaction = transaction;
     }
    public Transaction ajouterTransaction(Transaction t) {
        return transaction.save(t);
    }

    public List<Transaction> listerTransactions() {
        return transaction.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transaction.findById(id);
    }

    public Transaction modifierTransaction(Long id, Transaction updated) {
        return transaction.findById(id)
                .map(t -> {
                    t.setMontant(updated.getMontant());
                    t.setDate(updated.getDate());
                    t.setDescription(updated.getDescription());
                    return transaction.save(t);
                }).orElseThrow(() -> new RuntimeException("Transaction non trouvée"));
    }

    public void supprimerTransaction(Long id) {
        transaction.deleteById(id);
    }

}
