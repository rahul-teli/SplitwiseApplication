package com.splitwiseapplication.repository;

import com.splitwiseapplication.model.UserExpenses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserExpenseRepository extends JpaRepository<UserExpenses, Long> {
}
