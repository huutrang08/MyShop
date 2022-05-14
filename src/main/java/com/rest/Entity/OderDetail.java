package com.rest.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
public class OderDetail implements Serializable{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int OderDetailId;
   
   public int getOderDetailId() {
	return OderDetailId;
}

public void setOderDetailId(int oderDetailId) {
	OderDetailId = oderDetailId;
}

public int getQuantity() {
	return Quantity;
}

public void setQuantity(int quantity) {
	Quantity = quantity;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}

public Oder getOder() {
	return oder;
}

public void setOder(Oder oder) {
	this.oder = oder;
}

@Column(nullable = false)
  private int Quantity;
   @Column(nullable = false)
  private float total;
   
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "product_oder",
           joinColumns = @JoinColumn(name = "OderDetailId"),
           inverseJoinColumns = @JoinColumn(name = "productId")
           )
   private Collection<Product> products;
   
   public Collection<Product> getProducts() {
	return products;
}

public void setProducts(Collection<Product> products) {
	this.products = products;
}

private Oder oder;
}
