package com.example.kourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@RequiredArgsConstructor
public class Datas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String strasse;
    @Value("0")
    private int kv;
    @Value("0")
    private int etag;
    @Value("0")
    private int pod;
    @Value("0")
    private int domofon;
    private String name;
    private String forname;
    private String vatername;
    private String telefon;
    @OneToOne
    Orders orders;

}
