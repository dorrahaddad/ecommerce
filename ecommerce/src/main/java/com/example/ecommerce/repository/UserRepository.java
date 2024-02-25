package com.example.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	@Query("SELECT u FROM User u WHERE " +
	        "(:nom IS NULL OR u.nom LIKE CONCAT('%', LOWER(:nom), '%')) AND " +
	        "(:prenom IS NULL OR u.prenom LIKE CONCAT('%', LOWER(:prenom), '%')) AND " +
	        "(:adresse IS NULL OR u.adresse LIKE CONCAT('%', LOWER(:adresse), '%')) AND " +
	        "(:telephone IS NULL OR CAST(u.telephone AS string) LIKE CONCAT('%', :telephone, '%'))")
	List<User> rechercheAvancee(
	        @Param("nom") String nom,
	        @Param("prenom") String prenom,
	        @Param("adresse") String adresse,
	        @Param("telephone") Long telephone
	);
}