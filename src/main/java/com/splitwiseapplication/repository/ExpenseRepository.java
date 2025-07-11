package com.splitwiseapplication.repository;

import com.splitwiseapplication.model.Expense;
import com.splitwiseapplication.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroupId(Group group);
}
