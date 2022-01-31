package com.example.ExpensesApp.repository;

import com.example.ExpensesApp.entity.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesEntity, Integer > {
    List<ExpensesEntity> findAllByDeletedFalse();
}
