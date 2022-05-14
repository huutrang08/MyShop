package com.rest.Services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.rest.Entity.Cartitem;
import com.rest.Entity.Users;

public interface CartItemServices {

	void delete(Cartitem entity);

	void deleteById(Integer id);

	Optional<Cartitem> findById(Integer id);

	List<Cartitem> findAll();

	<S extends Cartitem> S save(S entity);

	List<Cartitem> findByUsers(Users users);

}
