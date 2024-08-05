package com.tms.mono.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.repository.AssighnedConsighnmentDetailsDao;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.repository.RouteDao;
import com.tms.mono.repository.VehicalDao;
import com.tms.mono.service.AssighnmentService;

@Service
public class AssighnmentServiceImpl implements AssighnmentService {

	private static final Logger LOGGER = LogManager.getLogger(AssighnmentServiceImpl.class);

	private AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao;

	private ConsighnmentDao consighnmentDao;

	private RouteDao routeDao;

	private VehicalDao vehicalDao;

	public AssighnmentServiceImpl(AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao,
			ConsighnmentDao consighnmentDao, RouteDao routeDao, VehicalDao vehicalDao) {
		super();
		this.assighnedConsighnmentDetailsDao = assighnedConsighnmentDetailsDao;
		this.consighnmentDao = consighnmentDao;
		this.routeDao = routeDao;
		this.vehicalDao = vehicalDao;
	}

	@Override
	public void assighnConsighnment(Long consigId, Long vehicalId) {

		LOGGER.info(" In <AssighnmentServiceImpl> starting assighnConsighnment");
		try {
			LOGGER.info("In try block finding details in database");
			Consighnment consighnment = consighnmentDao.findById(consigId).get();
			Vehical vehical = vehicalDao.findById(vehicalId).get();
			Route routeName = routeDao.findByRouteName(consighnment.getRoute().getRouteName());
			AssignedConsighnmentsDetails assignedConsighnmentsDetails = new AssignedConsighnmentsDetails();
			LOGGER.info("Setting details");
			assignedConsighnmentsDetails.setConsighnment(consighnment);
			assignedConsighnmentsDetails.setVehical(vehical);
			assignedConsighnmentsDetails.setRemainingFair(consighnment.getFare());
			assignedConsighnmentsDetails.setTotalFair(consighnment.getFare());
			assignedConsighnmentsDetails.setStatus(Status.ACTIVE);
			consighnment.setRoute(routeName);
			consighnment.setConsighnmentsDetails(assignedConsighnmentsDetails);

			LOGGER.info("Saving : " + assignedConsighnmentsDetails);
			assighnedConsighnmentDetailsDao.save(assignedConsighnmentsDetails);
			LOGGER.info("Saving : " + consighnment);
			consighnmentDao.save(consighnment);
		} catch (Exception e) {
			LOGGER.error("Exception occurs during assighnment of consighnment in service " + e.getStackTrace());
		}
	}

}
