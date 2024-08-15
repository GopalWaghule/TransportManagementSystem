package com.tms.mono.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tms.mono.model.Vehical;

@Repository
public interface VehicalDao extends JpaRepository<Vehical, Serializable> {
	
	Vehical findByNumber(String vehicalNumber);
	
	

}
