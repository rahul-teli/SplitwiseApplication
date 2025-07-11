package com.splitwiseapplication.service;

import com.splitwiseapplication.model.Group;
import com.splitwiseapplication.model.User;
import com.splitwiseapplication.repository.GroupRepository;
import com.splitwiseapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public GroupService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public Group createGroup(String groupName, List<Long> userIds) {
        List<User> users = userRepository.findAllById(userIds);
        if (users.size() != userIds.size()) {
            throw new IllegalArgumentException("No valid users found for the group.");
        }

        Group group = new Group(groupName, users);

        return groupRepository.save(group);
    }
}
