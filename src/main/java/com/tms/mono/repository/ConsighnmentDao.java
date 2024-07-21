package com.tms.mono.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.mono.enums.Status;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;

@Repository
public interface ConsighnmentDao extends JpaRepository<Consighnment, Serializable> {

	List<Consighnment> findByStatus(Status status);
	List<Consighnment> findByStatusAndRoute(Status status,Route route);
}
