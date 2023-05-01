package com.example.kourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int price;
    @ManyToOne
    Users user;
    @ManyToMany(mappedBy = "orderList")
    private List<Product> productList;
    @OneToOne(mappedBy = "orders")
    Datas datas;






//    @JoinTable(
//            name = "orders_products",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> productList = new ArrayList<>();

}
