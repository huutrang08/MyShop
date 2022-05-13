package com.rest.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.rest.Entity.Role;

public class UsersDTO implements Serializable {

	private int id;
	private String username;
	private String password;
	private boolean enable;
	private String email;
	   private Date date;
	private String fullname;
    private int phone;	
	private Set<OderDTO> oder;
	private Set<CartitemDTO> cartitems;
    private Set<Role> roles = new HashSet<>();

	public Set<CartitemDTO> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<CartitemDTO> cartitems) {
		this.cartitems = cartitems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Set<OderDTO> getOder() {
		return oder;
	}

	public void setOder(Set<OderDTO> oder) {
		this.oder = oder;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
