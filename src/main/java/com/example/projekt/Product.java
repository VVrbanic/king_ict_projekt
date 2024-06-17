package com.example.projekt;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private Float price;
    @Column(name="IMAGE")
    private String image;

}
