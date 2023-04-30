package com.example.kourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private  String originaleFileName;
    private Long size;
    private String contentType;
    @Lob
    private  byte[] bytes;
    @OneToOne(cascade =  CascadeType.REFRESH, fetch = FetchType.EAGER)
    private  Product product;
}
