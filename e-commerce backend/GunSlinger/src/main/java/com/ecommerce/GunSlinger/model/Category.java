package com.ecommerce.GunSlinger.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
//	@NotNull
	@Size(max = 50)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parent_category_id")
	private Category parentCategory;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private List<Product> products;
	
	private int level;
	
	public Category() {
		
	}

	public Category(Long id,  @Size(max = 50) String name, Category parentCategory, int level) {
		super();
		this.categoryId = id;
		this.name = name;
		this.parentCategory = parentCategory;
		this.level = level;
	}

	public Long getId() {
		return categoryId;
	}

	public void setId(Long id) {
		this.categoryId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", name=" + name + ", parentCategory=" + parentCategory + ", level=" + level
				+ "]";
	}
	
}
