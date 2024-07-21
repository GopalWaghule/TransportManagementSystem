package com.tms.mono.service;

import org.springframework.stereotype.Service;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Vehical;

@Service
public interface AssighnmentService {
	
	void assighnConsighnment(Consighnment consighnment,Vehical vehical,Double advance);

}
