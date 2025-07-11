package com.splitwiseapplication.controller;

import com.splitwiseapplication.dto.CreateGroupDto;
import com.splitwiseapplication.model.Group;
import com.splitwiseapplication.service.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group")
public class CreateGroup {

    private final GroupService groupService;
    public CreateGroup(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public Group createGroup (@RequestBody CreateGroupDto createGroupDto){
        return groupService.createGroup(createGroupDto.getName(), createGroupDto.getUserIds());
    }
}
