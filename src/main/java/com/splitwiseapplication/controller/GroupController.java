package com.splitwiseapplication.controller;

import com.splitwiseapplication.dto.CreateGroupDto;
import com.splitwiseapplication.model.Group;
import com.splitwiseapplication.service.GroupService;

import com.splitwiseapplication.strategy.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("")
    public Group createGroup(@RequestBody CreateGroupDto createGroupDto) {
        return groupService.createGroup(createGroupDto.getName(), createGroupDto.getUserIds());
    }

    @GetMapping("/{id}/settleUp")
    public List<Transaction> settleUpTransactions(@PathVariable(name = "id") Long groupId) {
        return groupService.settleUp(groupId);
    }
}
