package com.rest.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cartitem implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Users user;
	
	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
     



	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   @JoinTable(
	           name = "product_cart",
	           joinColumns = @JoinColumn(name = "CartId"),
	           inverseJoinColumns = @JoinColumn(name = "productId")
	           )
	   private Map<Integer,Product> products;

	public Map<Integer, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, Product> products) {
		this.products = products;
	}
	
	
}
