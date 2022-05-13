package com.rest.DTO;

import java.util.List;

import com.rest.Entity.Category;

public class CategoryResponse {
   private List<Category> categoryDTOs;

public List<Category> getCategoryDTOs() {
	return categoryDTOs;
}

public void setCategoryDTOs(List<Category> categoryDTOs) {
	this.categoryDTOs = categoryDTOs;
}
}
