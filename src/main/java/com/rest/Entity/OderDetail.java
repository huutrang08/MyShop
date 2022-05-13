package com.rest.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
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
   
   @ManyToOne
   @JoinColumn(name = "productId")
   private Product product;
   
   @ManyToOne
   @JoinColumn(name = "OderId")
   private Oder oder;
}
