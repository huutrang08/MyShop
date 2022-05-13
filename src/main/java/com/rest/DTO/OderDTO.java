package com.rest.DTO;

import java.io.Serializable;
import java.util.Set;
public class OderDTO implements Serializable{

   private int OderId;
   private  int total;
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
	public UsersDTO getUser() {
		return user;
	}
	public void setUser(UsersDTO user) {
		this.user = user;
	}
	public Set<OderDetail> getOderDetail() {
		return oderDetail;
	}
	public void setOderDetail(Set<OderDetail> oderDetail) {
		this.oderDetail = oderDetail;
	}
   private String status;	
	private UsersDTO user;
	private Set<OderDetail> oderDetail;
}
