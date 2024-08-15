package com.tms.mono.service;

import org.springframework.stereotype.Service;

@Service
public interface AssighnmentService {

	

	void assighnVehicalOwnerToVehical(String vehicalNumber, Long voId);

	//void assignConsignment(Long consigId, Long vehicalId);

	void assighnConsighnment(Long consigId, Long vehicalId);
}
