package com.splitwiseapplication.repository;

import com.splitwiseapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Long> {
}
