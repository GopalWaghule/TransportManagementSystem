package com.tms.mono.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;
import com.tms.mono.repository.AssighnedConsighnmentDetailsDao;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.repository.ConsighnmentOwnerDao;
import com.tms.mono.repository.DriverDao;
import com.tms.mono.repository.RouteDao;
import com.tms.mono.repository.VehicalDao;
import com.tms.mono.repository.VehicalOwnerDao;
import com.tms.mono.service.CreateService;

@Service
public class CreateServiceImpl implements CreateService{
	
	@Autowired
	private ConsighnmentDao consighnmentDao;
	
	@Autowired
	private DriverDao driverDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private VehicalDao vehicalDao;
	
	@Autowired
	private VehicalOwnerDao vehicalOwnerDao;
	
	@Autowired
	private ConsighnmentOwnerDao consighnmentOwnerDao;
	
	@Autowired
	private AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao;

	@Override
	public void addConsighnment(Consighnment consighnment) {
		consighnment.setStatus(Status.Non_Active);
		consighnmentDao.save(consighnment);
		
	}

	@Override
	public void addDriver(Driver driver) {
		driverDao.save(driver);	
	}

	@Override
	public void addRoute(Route route) {
		routeDao.save(route);
	}

	@Override
	public void addVehical(Vehical vehical) {
		vehicalDao.save(vehical);	
	}

	@Override
	public void addVehicalOwner(VehicalOwner owner) {
		vehicalOwnerDao.save(owner);		
	}

	@Override
	public void addConsighnmentOwner(ConsighnmentOwner consighnmentOwner) {
		consighnmentOwnerDao.save(consighnmentOwner);		
	}

	@Override
	public void addAssignedConsighnmentDetails(AssignedConsighnmentsDetails details) {
		assighnedConsighnmentDetailsDao.save(details);		
	}

}
