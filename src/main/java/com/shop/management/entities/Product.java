package com.shop.management.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is necessary for returning updated id field by save() method
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
}
