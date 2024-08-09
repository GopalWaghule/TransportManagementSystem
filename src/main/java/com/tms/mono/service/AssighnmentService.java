package com.tms.mono.service;

import org.springframework.stereotype.Service;

@Service
public interface AssighnmentService {

	void assighnConsighnment(Long cid, Long vehical);

	void assighnVehicalOwnerToVehical(String vehicalNumber, Long voId);
}
