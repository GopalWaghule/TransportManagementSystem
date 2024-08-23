package com.tms.mono.service;

import org.springframework.stereotype.Service;

import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;

@Service
public interface AssighnmentService {

	AssignedConsighnmentsDetails createAssignedConsignmentsDetails(Consighnment consignment, Vehical vehicle,
			Route routeName);

	void assighnVehicalOwnerToVehical(String vehicalNumber, Long voId);

	// void assignConsignment(Long consigId, Long vehicalId);

	void assighnConsighnment(Long consigId, Long vehicalId);

	Boolean checkNonActiveConsignment(Consighnment consighnment);
}
