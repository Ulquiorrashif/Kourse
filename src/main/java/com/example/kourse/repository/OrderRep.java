package com.example.kourse.repository;


import com.example.kourse.entity.Orders;
import com.example.kourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRep extends JpaRepository<Orders, Long> {
    List<Orders> getAllByUser(Users user);

}
