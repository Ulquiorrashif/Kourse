package com.example.kourse.repository;

import com.example.kourse.entity.Image;
import com.example.kourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRep extends JpaRepository<Image, Long> {
    Image findByProduct(Product product);

}
