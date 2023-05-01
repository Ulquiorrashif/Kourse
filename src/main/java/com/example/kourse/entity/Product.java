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
    private boolean buy;


    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Image image;

    @ManyToMany
    private List<Orders> orderList;
    @ManyToMany
    private List<Korsina>  korsina;



    public Product(String title, String author, int price, boolean buy) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.buy = buy;
    }
}
