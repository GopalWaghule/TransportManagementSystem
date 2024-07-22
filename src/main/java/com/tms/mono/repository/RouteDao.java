package com.tms.mono.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.mono.model.Route;

@Repository
public interface RouteDao extends JpaRepository<Route, Serializable>{
	
	Route findByRouteName(String name);

}
