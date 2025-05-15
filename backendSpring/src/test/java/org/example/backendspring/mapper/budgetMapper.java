package org.example.backendspring.mapper;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.budget;
import org.springframework.stereotype.Component;

@Component
//@Mapper(componentModel = "spring")
public class budgetMapper {
    BudgetDto toDto(budget entity) {
        return null;
    }

    budget toEntity(BudgetDto dto) {
        return null;
    }
}
