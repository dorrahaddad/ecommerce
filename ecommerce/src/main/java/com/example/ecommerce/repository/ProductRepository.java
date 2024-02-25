package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
	@Query("SELECT p FROM Product p WHERE" +
		       "(:name IS NULL OR p.name LIKE CONCAT('%', LOWER(:name), '%')) " +
		       "AND (:description IS NULL OR p.description LIKE CONCAT('%', :description, '%')) " +
		       "AND (:quantity IS NULL OR p.quantity = :quantity) " +
		       "AND (:price IS NULL OR p.price = :price) " +
		       "AND (:imgUrl IS NULL OR p.imgUrl LIKE CONCAT('%', :imgUrl, '%')) "+
			   "AND (:categoryName IS NULL OR p.category.categoryName LIKE CONCAT('%', :categoryName, '%'))")
	    List<Product> advancedSearch(
	            @Param("name") String name,
	            @Param("description") String description,
	            @Param("quantity") Integer quantity,
	            @Param("price") Double price,
	            @Param("imgUrl") String imgUrl,
	            @Param("categoryName") String categoryName

	    );
	  @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
	    List<Product> findByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}
