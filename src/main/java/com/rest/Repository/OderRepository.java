package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Entity.Oder;
@Repository
public interface OderRepository extends JpaRepository<Oder, Integer> {

}
