package com.example.kourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int price;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Image image;

    @ManyToMany(mappedBy = "productList")
    private List<Orders> orderList = new ArrayList<>();
    @ManyToOne
    private Korsina korsina;



    public Product(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
