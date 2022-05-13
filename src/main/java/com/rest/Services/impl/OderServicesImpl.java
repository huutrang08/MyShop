package com.rest.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Entity.Oder;
import com.rest.Repository.OderRepository;
import com.rest.Services.OderServices;

@Service
public class OderServicesImpl implements OderServices {
	@Autowired
    OderRepository oderRepository;

	@Override
	public <S extends Oder> S save(S entity) {
		return oderRepository.save(entity);
	}

	@Override
	public List<Oder> findAll() {
		return oderRepository.findAll();
	}

	@Override
	public Optional<Oder> findById(Integer id) {
		return oderRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return oderRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id) {
		oderRepository.deleteById(id);
	}

	@Override
	public void delete(Oder entity) {
		oderRepository.delete(entity);
	}

	@Override
	public Oder getById(Integer id) {
		return oderRepository.getById(id);
	}
}
