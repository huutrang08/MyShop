package com.rest.DTO;

import java.io.Serializable;
import java.util.Set;

	
public class CategoryDTO implements Serializable{
   private Long categoryId;
   private String name;
	public Long getCategotyId() {
		return categoryId;
	}
   private Set<ProductDTO> products;
	public Long getCategoryId() {
	return categoryId;
}

public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}

public Set<ProductDTO> getProducts() {
	return products;
}

public void setProducts(Set<ProductDTO> products) {
	this.products = products;
}

	public void setCategotyId(Long categotyId) {
		this.categoryId = categotyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
