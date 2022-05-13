package com.rest.Services;

import java.util.List;
import java.util.Optional;

import com.rest.Entity.Oder;

public interface OderServices {

	Oder getById(Integer id);

	void delete(Oder entity);

	void deleteById(Integer id);

	boolean existsById(Integer id);

	Optional<Oder> findById(Integer id);

	List<Oder> findAll();

	<S extends Oder> S save(S entity);

}
