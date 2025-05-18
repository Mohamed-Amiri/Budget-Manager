package org.example.backendspring.dto;

public record TransactionDto(
        String type,
        String description,
        double amount,
        Long category_id,
        Long budget_id
) {

}