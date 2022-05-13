package com.rest.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long categoryId;
	@Column(name = "categoryName",length = 100,
			columnDefinition = "nvarchar(100) not null")
   private String name;
	public Long getCategotyId() {
		return categoryId;
	}
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
   private Set<Product> products;
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
