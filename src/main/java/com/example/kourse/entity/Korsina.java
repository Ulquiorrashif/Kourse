package com.example.kourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Korsina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private  Users user;
    @ManyToMany (mappedBy = "korsina" )
    @Cascade(CascadeType.REMOVE)
    private List<Product> productList= new ArrayList<>();
}
