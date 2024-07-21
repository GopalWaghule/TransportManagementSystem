package com.tms.mono.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Vehical;
import com.tms.mono.repository.AssighnedConsighnmentDetailsDao;
import com.tms.mono.service.AssighnmentService;

@Service
public class AssighnmentServiceImpl implements AssighnmentService{
	
	@Autowired
	private AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao;

	@Override
	public void assighnConsighnment(Consighnment consighnment,Vehical vehical,Double advance) {
		
		AssignedConsighnmentsDetails assignedConsighnmentsDetails=new AssignedConsighnmentsDetails();
		assignedConsighnmentsDetails.setConsighnment(consighnment);
		assignedConsighnmentsDetails.setVehical(vehical);
		assignedConsighnmentsDetails.setAdvance(advance);
		assignedConsighnmentsDetails.setRemainingFair(consighnment.getFare()-advance);
		assignedConsighnmentsDetails.setTotalFair(consighnment.getFare());
		assignedConsighnmentsDetails.setStatus(Status.ACTIVE);
		
		assighnedConsighnmentDetailsDao.save(assignedConsighnmentsDetails);
	}
	
	

}
