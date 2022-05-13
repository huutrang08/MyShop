package com.rest.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productId;
	@Column(columnDefinition = "nvarchar(100) not null")
  private String name;
	@Column(nullable = false)
  private int quantity;
	@Column(nullable = false)
  private double unitPrice;
	@Column(columnDefinition = "nvarchar(200) not null")
  private String description;
	@Column(nullable = false)
  private double discount;
	@Temporal(TemporalType.DATE)
  private Date date;
	@Column(nullable = false)
  private short status;
	@Column(nullable = false)
  private int sold;

	public Set<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private Set<OderDetail> oderDetail;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private Set<Cartitem> cartitems;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<OderDetail> getOderDetail() {
		return oderDetail;
	}

	public void setOderDetail(Set<OderDetail> oderDetail) {
		this.oderDetail = oderDetail;
	}
}
