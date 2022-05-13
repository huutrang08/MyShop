package com.rest.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rest.Entity.Category;

public interface CategoryServices {

	Category getById(Integer id);

	void delete(Category entity);

	void deleteById(Integer id);

	boolean existsById(Integer id);

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	<S extends Category> S save(S entity);

	List<Category> findByNameContaining(String name);

	Page<Category> findAll(Pageable pageable);

	Page<Category> findByNameContaining(String name, Pageable pageable);

}
