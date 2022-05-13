package com.rest.Services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Entity.Cartitem;
import com.rest.Entity.Users;
import com.rest.Repository.CartItemRepository;
import com.rest.Services.CartItemServices;
@Service
public class CartItemServicesImpl implements CartItemServices{
	@Autowired
 CartItemRepository cartItemRepository;
	
	@Override
	public void add(Cartitem cartitem,Map<Integer, Cartitem> map,int id) {
		Cartitem cart = map.get(id);
		if (cart != null) {
			cart.setQuantity(cart.getQuantity()+cartitem.getQuantity());
			save(cart);
		}save(cartitem);
	}
	
	@Override
	public List<Cartitem> findByUsers(Users users) {
		return cartItemRepository.findByUsers(users);
	}

	@Override
	public <S extends Cartitem> S save(S entity) {
		return cartItemRepository.save(entity);
	}

	@Override
	public List<Cartitem> findAll() {
		return cartItemRepository.findAll();
	}

	@Override
	public Optional<Cartitem> findById(Integer id) {
		return cartItemRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		cartItemRepository.deleteById(id);
	}

	@Override
	public void delete(Cartitem entity) {
		cartItemRepository.delete(entity);
	}
	
}
