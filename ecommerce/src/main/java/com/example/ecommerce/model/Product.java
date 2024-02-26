package com.example.ecommerce.model;


import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
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
	
	private String imgUrl;

	@ManyToOne
	@JoinColumn(name = "category_id" , referencedColumnName = "id")
	//@JsonBackReference
	private Category category ;
	

	@OneToMany(mappedBy="product", cascade = CascadeType.MERGE)
	private List<CommandLine> commandLines ;


}
