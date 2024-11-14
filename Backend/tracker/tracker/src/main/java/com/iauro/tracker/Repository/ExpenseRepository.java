package com.iauro.tracker.Repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.iauro.tracker.Model.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
}
