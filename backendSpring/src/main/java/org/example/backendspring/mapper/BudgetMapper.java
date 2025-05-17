package org.example.backendspring.mapper;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.Budget;

public class BudgetMapper {

    public static BudgetDto toDto(Budget entity) {
        return BudgetDto.builder()
                .id(entity.getId())
                .montant(entity.getMontant())
                .Enum(entity.getEnum())
                .date(entity.getDate())
                .build();
    }

    public static Budget toEntity(BudgetDto dto) {
        Budget entity = new Budget();
        entity.setId(dto.getId());
        entity.setMontant(dto.getMontant());
        entity.setEnum(dto.getEnum());
        entity.setDate(dto.getDate());
        return entity;
    }
}
