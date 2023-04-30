package com.example.kourse.repository;

import com.example.kourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRep extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
