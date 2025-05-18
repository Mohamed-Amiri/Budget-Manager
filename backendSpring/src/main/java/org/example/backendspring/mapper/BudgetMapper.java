package org.example.backendspring.mapper;

import org.example.backendspring.dto.BudgetDto;
import org.example.backendspring.entity.budget;

public class BudgetMapper {

    public static BudgetDto toDto(budget entity) {
        return BudgetDto.builder()
                .id(entity.getId())
                .montant(entity.getMontant())
                .enumValue(entity.getEnum())
                .date(entity.getDate())
                .build();
    }

    public static budget toEntity(BudgetDto dto) {
        budget entity = new budget();
        entity.setId(dto.getId());
        entity.setMontant(dto.getMontant());
        entity.setEnum(dto.getEnum());
        entity.setDate(dto.getDate());
        return entity;
    }
}
