package com.splitwiseapplication.strategy;

import com.splitwiseapplication.model.User;
import lombok.Data;

@Data
public class Transaction {

    double amount;
    User paidBy;
    User paidTo;

    public Transaction(double amount, User paidBy, User paidTo) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
    }
}