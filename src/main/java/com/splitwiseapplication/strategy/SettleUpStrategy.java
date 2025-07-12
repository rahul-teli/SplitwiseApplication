package com.splitwiseapplication.strategy;

import com.splitwiseapplication.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);

}
