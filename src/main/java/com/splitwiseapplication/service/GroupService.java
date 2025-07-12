package com.splitwiseapplication.service;

import com.splitwiseapplication.model.Expense;
import com.splitwiseapplication.model.Group;
import com.splitwiseapplication.model.User;
import com.splitwiseapplication.repository.ExpenseRepository;
import com.splitwiseapplication.repository.GroupRepository;
import com.splitwiseapplication.repository.UserRepository;
import com.splitwiseapplication.strategy.OptimalSettleUp;
import com.splitwiseapplication.strategy.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;

    public GroupService(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public Group createGroup(String name, List<Long> userIds) {
        List<User> users = userRepository.findAllById(userIds);

        // Users requested, vs the users found in the DB
        if (userIds.size() != users.size()) {
            throw new IllegalArgumentException("Users are invalid.");
        }

        Group group = new Group(name, users);

        return groupRepository.save(group);
    }

    public List<Transaction> settleUp(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() ->
                new IllegalArgumentException("Invalid group id"));
        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        return new OptimalSettleUp().settleUp(expenses);
    }
}