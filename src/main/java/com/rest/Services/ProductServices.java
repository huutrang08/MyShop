package com.rest.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rest.Entity.Product;

public interface ProductServices {

	Product getById(Integer id);

	void delete(Product entity);

	void deleteById(Integer id);

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> findAll();

	<S extends Product> S save(S entity);

	Page<Product> findByNameContaining(String name, Pageable pageable);

	List<Product> findByNameContaining(String name);

	Page<Product> findAll(Pageable pageable);

}
