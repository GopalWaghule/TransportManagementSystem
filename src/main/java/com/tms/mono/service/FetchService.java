package com.tms.mono.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;

@Service
public interface FetchService {

	List<Consighnment> findAllActiveConsighnment();
	List<Consighnment> findAllActiveConsighnmentByRoute(Route route);
	
	
	
	
}
