package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	@NonNull
	private String name;
	
	@Lob
	private String description;
	
	private int quantity;
	
	private double price;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable=false)
    private Category category;

}
