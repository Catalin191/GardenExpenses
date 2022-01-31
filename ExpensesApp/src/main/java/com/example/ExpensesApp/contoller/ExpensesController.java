package com.example.ExpensesApp.contoller;

import com.example.ExpensesApp.entity.ExpensesEntity;
import com.example.ExpensesApp.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/expenses")
    public ModelAndView getExpenses(){
        ModelAndView modelAndView = new ModelAndView("viewExpenses");
        modelAndView.addObject("expenses", expensesService.getAllExpenses());

        return modelAndView;
    }

    @GetMapping("/addExpense")
    public ModelAndView addExpense(){
        ModelAndView modelAndView = new ModelAndView("addExpense");
        modelAndView.addObject("expense", new ExpensesEntity());

        return modelAndView;
    }

    @PostMapping("/addExpense")
    public ModelAndView addExpense(@Valid @ModelAttribute("expense") ExpensesEntity entity, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/expenses");

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("addExpense");
        }else {
            expensesService.saveExpense(entity);
            modelAndView.addObject("successMessage", "Expense has been added successfully");
        }

        return modelAndView;
    }

    @GetMapping("/updateExpense/{id}")
    public ModelAndView updateExpense(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("updateExpense");
        modelAndView.addObject("expense", expensesService.getExpense(id));

        return modelAndView;
    }

    @PostMapping("/updateExpense")
    public ModelAndView updateExpense(@Valid @ModelAttribute("expense") ExpensesEntity entity, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/expenses");

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("updateExpense");
            modelAndView.addObject("errorMessage", "Update failed");
        }else {
            expensesService.saveExpense(entity);
            modelAndView.addObject("successMessage", "Expense has been updated successfully");
        }

        return modelAndView;
    }

    @GetMapping("/deleteExpense/{id}")
    public ModelAndView deleteExpenses(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("redirect:/expenses");
        expensesService.deleteExpense(id);

        return modelAndView;
    }


}
