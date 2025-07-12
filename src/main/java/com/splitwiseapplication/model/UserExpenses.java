package com.splitwiseapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_expenses")
@AllArgsConstructor
@NoArgsConstructor
public class UserExpenses extends BaseModel implements Comparable<UserExpenses>{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    int amount;

    @Override
    public int compareTo(UserExpenses userExpense) {
        return Integer.compare(amount, userExpense.amount);
    }
}
