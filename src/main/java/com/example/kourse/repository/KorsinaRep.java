package com.example.kourse.repository;

import com.example.kourse.entity.Korsina;
import com.example.kourse.entity.Product;
import com.example.kourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorsinaRep extends JpaRepository<Korsina,Long> {
    Korsina findByUser(Users user);

}
