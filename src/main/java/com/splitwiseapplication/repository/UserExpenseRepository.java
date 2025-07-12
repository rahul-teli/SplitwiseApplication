package com.splitwiseapplication.repository;

import com.splitwiseapplication.model.UserExpense;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
}
