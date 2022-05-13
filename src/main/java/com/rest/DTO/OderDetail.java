package com.rest.DTO;

import java.io.Serializable;

public class OderDetail implements Serializable{
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

public ProductDTO getProduct() {
	return product;
}

public void setProduct(ProductDTO product) {
	this.product = product;
}

public OderDTO getOder() {
	return oder;
}

public void setOder(OderDTO oder) {
	this.oder = oder;
}
  private int Quantity;
  private float total;
   private ProductDTO product;
   private OderDTO oder;
}
