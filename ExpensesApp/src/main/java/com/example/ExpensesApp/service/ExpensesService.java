package com.example.ExpensesApp.service;

import com.example.ExpensesApp.entity.ExpensesEntity;
import com.example.ExpensesApp.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    public List<ExpensesEntity> getAllExpenses(){
        return expensesRepository.findAllByDeletedFalse();

    }

    public ExpensesEntity getExpense(Integer id){
        return expensesRepository.getOne(id);
    }

    public void saveExpense(ExpensesEntity entity){
        entity.setDeleted(false);
        expensesRepository.save(entity);
    }

    public void deleteExpense(Integer id){
        ExpensesEntity entity = expensesRepository.getOne(id);
        entity.setDeleted(true);
        expensesRepository.save(entity);
    }

}
