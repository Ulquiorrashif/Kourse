package com.example.kourse.repository;

import com.example.kourse.entity.Korsina;
import com.example.kourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRep extends JpaRepository<Product,Long> {
    Product getProductsById(Long id);
    List<Product> getAllByKorsina(Korsina korsina);
    void removeProductByKorsina(Korsina korsina);
    void removeProductByTitle(String title);
    void removeProductById(Long Id);
}
