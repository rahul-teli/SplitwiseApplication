package com.splitwiseapplication.service;

import com.splitwiseapplication.dto.CreateExpenseDto;
import com.splitwiseapplication.model.Expense;
import com.splitwiseapplication.model.Group;
import com.splitwiseapplication.model.User;
import com.splitwiseapplication.model.UserExpenses;
import com.splitwiseapplication.repository.ExpenseRepository;
import com.splitwiseapplication.repository.GroupRepository;
import com.splitwiseapplication.repository.UserExpenseRepository;
import com.splitwiseapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;
    private final UserExpenseRepository userExpenseRepository;

    public ExpenseService(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
    }


    @Transactional
    public Expense createExpense(CreateExpenseDto createExpenseDto) {


        // Group to which the expense is attached to.
        Optional<Group> groupOptional = groupRepository.findById(createExpenseDto.getGroupId());


        // Creates a corresponding expense object


        // Finds out who all paid
        List<UserExpenses> paidByUserExpenses = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry: createExpenseDto.getPaidBy().entrySet()) {
            Long userId = entry.getKey();
            int amount = entry.getValue();
            User user = userRepository.findById(userId).get();
            UserExpenses userExpense = new UserExpenses(user, amount);
            paidByUserExpenses.add(userExpense);
        }
        List<UserExpenses> paidByUsers = userExpenseRepository.saveAll(paidByUserExpenses);

        // Finds out who all owe
        List<UserExpenses> owedByUserExpenses = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry: createExpenseDto.getOwedBy().entrySet()) {
            Long userId = entry.getKey();
            int amount = entry.getValue();
            User user = userRepository.findById(userId).get();
            UserExpenses userExpense = new UserExpenses(user, -amount);
            owedByUserExpenses.add(userExpense);
        }
        List<UserExpenses> owedByUsers = userExpenseRepository.saveAll(owedByUserExpenses);

        // Add entries to the DB.
        Expense expense = Expense.builder()
                .name(createExpenseDto.getName())
                .group(groupOptional.get())
                .amount(createExpenseDto.getAmount())
                .owedBy(owedByUsers).paidBy(paidByUsers)
                .build();

        return expenseRepository.save(expense);

    }
}