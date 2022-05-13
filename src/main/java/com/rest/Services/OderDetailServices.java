package com.rest.Services;

import java.util.List;
import java.util.Optional;

import com.rest.Entity.OderDetail;

public interface OderDetailServices {

	OderDetail getById(Integer id);

	void delete(OderDetail entity);

	void deleteById(Integer id);

	boolean existsById(Integer id);

	Optional<OderDetail> findById(Integer id);

	List<OderDetail> findAll();

	<S extends OderDetail> S save(S entity);

}
