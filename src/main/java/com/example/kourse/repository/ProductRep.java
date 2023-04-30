package com.example.kourse.repository;

import com.example.kourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product,Long> {
    Product getProductsById(Long id);
}
