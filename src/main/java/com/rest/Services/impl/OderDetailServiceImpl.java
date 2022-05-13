package com.rest.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Entity.OderDetail;
import com.rest.Repository.OderDetailRepository;
import com.rest.Services.OderDetailServices;

@Service
public class OderDetailServiceImpl implements OderDetailServices{
	@Autowired
   OderDetailRepository oderDetailRepository;

	@Override
	public <S extends OderDetail> S save(S entity) {
		return oderDetailRepository.save(entity);
	}

	@Override
	public List<OderDetail> findAll() {
		return oderDetailRepository.findAll();
	}

	@Override
	public Optional<OderDetail> findById(Integer id) {
		return oderDetailRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return oderDetailRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id) {
		oderDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OderDetail entity) {
		oderDetailRepository.delete(entity);
	}

	@Override
	public OderDetail getById(Integer id) {
		return oderDetailRepository.getById(id);
	}
	
	
}
