package com.rest.Repository;

import com.rest.Entity.Product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByNameContaining(String name);
    Page<Product> findByNameContaining(String name,Pageable pageable);
}
