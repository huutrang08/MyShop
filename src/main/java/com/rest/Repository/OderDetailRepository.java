package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Entity.OderDetail;

@Repository
public interface OderDetailRepository extends JpaRepository<OderDetail,Integer> {

}
