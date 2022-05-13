package com.rest.Entity;

import java.io.Serializable;
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
@Table
@Entity
public class Oder implements Serializable{
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int OderId;
	@Column(nullable = false)
   private  int total;
	@Column(nullable = false)
   private float discount;
	public int getOderId() {
		return OderId;
	}

	public void setOderId(int oderId) {
		OderId = oderId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<OderDetail> getOderDetail() {
		return oderDetail;
	}

	public void setOderDetail(Set<OderDetail> oderDetail) {
		this.oderDetail = oderDetail;
	}

	@Column(nullable = false)
   private String status;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Users user;
	
	@OneToMany(mappedBy = "oder",cascade = CascadeType.ALL)
	private Set<OderDetail> oderDetail;
}
