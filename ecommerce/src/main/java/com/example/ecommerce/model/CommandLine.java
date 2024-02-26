package com.example.ecommerce.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "COMMANDLINE")
public class CommandLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int quantity;
	private double prix;

	
	@ManyToOne
	@JoinColumn(name = "cmd_id" , referencedColumnName = "id")
	private Command command ;
	
	@ManyToOne
	@JoinColumn(name = "product_id" , referencedColumnName = "id")
	private Product product;

	public CommandLine(Product product) {
		super();
		this.product = product;
	}
	
	
	
	
 

}
