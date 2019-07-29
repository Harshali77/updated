package com.cts.vehicleservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.vehicleservice.model.SpareParts;

public interface PartRepository extends JpaRepository<SpareParts, Integer> {
	List<SpareParts> findAllBypartId(Integer partId);
}
