package com.tms.mono.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.mono.model.Consighnment;

@Service
public interface FetchService {

	List<Consighnment> findAllConsighnment();
	
	
}
