package org.example.backendspring.repository;

import org.example.backendspring.entity.budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface budgetRepository extends JpaRepository<budget, Long> {


}
