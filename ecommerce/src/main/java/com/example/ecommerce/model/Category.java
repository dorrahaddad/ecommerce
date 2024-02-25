package com.example.ecommerce.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy="category", cascade = CascadeType.MERGE)
    //fetch = FetchType.LAZY
    //@JsonManagedReference
    private List<Product> products;

}
