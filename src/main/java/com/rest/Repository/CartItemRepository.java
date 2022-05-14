package com.rest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Entity.Cartitem;
import com.rest.Entity.Users;
@Repository
public interface CartItemRepository extends JpaRepository<Cartitem, Integer> {
	List<Cartitem> findByUserId(Users users);
}
