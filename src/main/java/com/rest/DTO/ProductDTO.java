package com.rest.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO implements Serializable{
  private Long productId;
  private String name;
  private int quantity;
  private double unitPrice;
  private String description;
  private double discount;
  private Date date;
  private short status;
  private int sold;
	private CategoryDTO category;
	private Set<OderDetail> oderDetail;
	private Set<CartitemDTO> cartitems;
	public Set<CartitemDTO> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<CartitemDTO> cartitems) {
		this.cartitems = cartitems;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Set<OderDetail> getOderDetail() {
		return oderDetail;
	}

	public void setOderDetail(Set<OderDetail> oderDetail) {
		this.oderDetail = oderDetail;
	}
}
