package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String nom;
    
    private String prenom;
    
    @Column(nullable = false)
    private String password;
    
    @Column(unique = true)
    private long telephone;
    
    private String adresse;
    
    private Role role;

}