package com.ecommerce.GunSlinger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.name = :name")
	public Category findByName(@Param("name") String name);
	
	@Query("Select c from Category c Where c.name=:name And c.parentCategory.name=:parentCategoryName")
	public Category findByNameAndParent(@Param("name") String name, @Param("parentCategoryName") String parentCategoryName);
	
}
