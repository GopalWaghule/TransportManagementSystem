package com.tms.mono.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;
import com.tms.mono.repository.AssighnedConsighnmentDetailsDao;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.repository.RouteDao;
import com.tms.mono.repository.VehicalDao;
import com.tms.mono.repository.VehicalOwnerDao;
import com.tms.mono.service.AssighnmentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Synchronized;

@Service
public class AssighnmentServiceImpl implements AssighnmentService {

	private static final Logger LOGGER = LogManager.getLogger(AssighnmentServiceImpl.class);

	private AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao;

	private ConsighnmentDao consighnmentDao;

	private RouteDao routeDao;

	private VehicalDao vehicalDao;

	private VehicalOwnerDao vehicalOwnerDao;

	public AssighnmentServiceImpl(AssighnedConsighnmentDetailsDao assighnedConsighnmentDetailsDao,
			ConsighnmentDao consighnmentDao, RouteDao routeDao, VehicalDao vehicalDao,
			VehicalOwnerDao vehicalOwnerDao) {
		super();
		this.assighnedConsighnmentDetailsDao = assighnedConsighnmentDetailsDao;
		this.consighnmentDao = consighnmentDao;
		this.routeDao = routeDao;
		this.vehicalDao = vehicalDao;
		this.vehicalOwnerDao = vehicalOwnerDao;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public void assighnConsighnment(Long consigId, Long vehicalId)
	 * {
	 * 
	 * LOGGER.info(" In <AssighnmentServiceImpl> starting assighnConsighnment"); try
	 * { LOGGER.info("In try block finding details in database"); LOGGER.
	 * info("Finding Consighnment , Vehical and related Routes for assighning consighnment...."
	 * ); Consighnment consighnment = consighnmentDao.findById(consigId).get();
	 * Vehical vehical = vehicalDao.findById(vehicalId).get();
	 * 
	 * 
	 * Route routeName =
	 * routeDao.findByStartLocationAndDestination(consighnment.getStartingPlace(),
	 * consighnment.getDestination());
	 * LOGGER.info("Creating new : 'AssignedConsighnmentsDetails' ");
	 * AssignedConsighnmentsDetails assignedConsighnmentsDetails = new
	 * AssignedConsighnmentsDetails(); LOGGER.info("Setting details........");
	 * 
	 * try { LOGGER.info("Setting route"); consighnment.setRoute(routeName);
	 * LOGGER.info("route added");
	 * 
	 * } catch (Exception e) { LOGGER.info("Exception setting Route : " +
	 * e.getMessage().toString()); } try { LOGGER.info("Setting consighnment");
	 * assignedConsighnmentsDetails.setConsighnment(consighnment);
	 * LOGGER.info("consighnment added"); } catch (Exception e) {
	 * LOGGER.info("Exception Setting consighnment : " + e.getMessage().toString());
	 * }
	 * 
	 * try { LOGGER.info("Setting Vehical");
	 * assignedConsighnmentsDetails.setVehical(vehical);
	 * LOGGER.info("Vehical added"); } catch (Exception e) {
	 * LOGGER.info("Exception Setting Vehical : " + e.getMessage().toString()); }
	 * 
	 * assignedConsighnmentsDetails.setRemainingFair(consighnment.getFare());
	 * assignedConsighnmentsDetails.setTotalFair(consighnment.getFare());
	 * assignedConsighnmentsDetails.setStatus(Status.ACTIVE);
	 * 
	 * consighnment.setConsighnmentsDetails(assignedConsighnmentsDetails);
	 * 
	 * LOGGER.info("Saving : " + consighnment.toString());
	 * consighnmentDao.save(consighnment); LOGGER.info("Saving : " +
	 * assignedConsighnmentsDetails.toString());
	 * assighnedConsighnmentDetailsDao.save(assignedConsighnmentsDetails);
	 * 
	 * } catch (Exception e) { LOGGER.error(
	 * "Exception occurs during assighnment of consighnment in service:\n " +
	 * e.getMessage().toString()); LOGGER.
	 * info("Transaction RollBacked ................................................."
	 * ); }
	 * 
	 * LOGGER.info("xxxxxxxxxxxxxxxxx  Service Layer exit xxxxxxxxxxxx");
	 * 
	 * }
	 */

	@Override
	@Transactional
	@Synchronized
	public void assighnConsighnment(Long consigId, Long vehicalId) {
		LOGGER.info("In <AssignmentServiceImpl> starting assignConsignment");

		Consighnment consignment = consighnmentDao.findById(consigId)
				.orElseThrow(() -> new EntityNotFoundException("Consignment not found"));
		if (consignment.getConsighnmentsDetails() != null) {
			try {
				LOGGER.info("Finding Consignment, Vehicle, and related Routes for assigning consignment...");

				Vehical vehicle = vehicalDao.findById(vehicalId)
						.orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

				Route routeName = routeDao.findByStartLocationAndDestination(consignment.getStartingPlace(),
						consignment.getDestination());

				AssignedConsighnmentsDetails assignedConsignmentsDetails = createAssignedConsignmentsDetails(
						consignment, vehicle, routeName);

				consignment.setConsighnmentsDetails(assignedConsignmentsDetails);

				
					LOGGER.info("Saving consignment: {}", consignment);
					consighnmentDao.save(consignment);
					LOGGER.info("Saving assigned consignment details: {}", assignedConsignmentsDetails);
					assighnedConsighnmentDetailsDao.save(assignedConsignmentsDetails);
				

			} catch (EntityNotFoundException e) {
				LOGGER.error("Entity not found: {}", e.getMessage());
			} catch (Exception e) {
				LOGGER.error("Exception occurs during assignment of consignment in service: {}", e.getMessage());
				LOGGER.info("Transaction rolled back.");
			}
		} else {
			LOGGER.error("Consighnment already assined !!!!!");
			LOGGER.info("Consighnment already assined !!!!!");
		}

		LOGGER.info("Service Layer exit");
	}

	private AssignedConsighnmentsDetails createAssignedConsignmentsDetails(Consighnment consignment, Vehical vehicle,
			Route routeName) {
		AssignedConsighnmentsDetails assignedConsignmentsDetails = new AssignedConsighnmentsDetails();

		try {
			LOGGER.info("Setting route");
			consignment.setRoute(routeName);
			LOGGER.info("Route added");
		} catch (Exception e) {
			LOGGER.error("Exception setting Route: {}", e.getMessage());
		}

		try {
			LOGGER.info("Setting consignment");
			assignedConsignmentsDetails.setConsighnment(consignment);
			LOGGER.info("Consignment added");
		} catch (Exception e) {
			LOGGER.error("Exception setting consignment: {}", e.getMessage());
		}

		try {
			LOGGER.info("Setting vehicle");
			assignedConsignmentsDetails.setVehical(vehicle);
			LOGGER.info("Vehicle added");
		} catch (Exception e) {
			LOGGER.error("Exception setting vehicle: {}", e.getMessage());
		}

		assignedConsignmentsDetails.setRemainingFair(consignment.getFare());
		assignedConsignmentsDetails.setTotalFair(consignment.getFare());
		assignedConsignmentsDetails.setStatus(Status.ACTIVE);

		return assignedConsignmentsDetails;
	}

	@Override
	@Transactional
	public void assighnVehicalOwnerToVehical(String vehicalNumber, Long voId) {
		try {
			LOGGER.info("Assighning Vehical Owner to vehical");
			LOGGER.info("Getting Vehical By its vehicalNumber");
			Vehical byId = vehicalDao.findByNumber(vehicalNumber);

			if (byId == null) {
				LOGGER.info("Vehicle not found for number: " + vehicalNumber);
				return;
			}

			LOGGER.info(" Vehical found : ");
			LOGGER.info("Getting VehicalOwner by its id");
			VehicalOwner vehicalOwner = vehicalOwnerDao.findById(voId).get();

			if (vehicalOwner == null) {
				LOGGER.info("VehicalOwner not found for ID: " + voId);
				return;
			}

			byId.setOwner(vehicalOwner);
			LOGGER.info("VehicalOwner assigned to the vehicle: ");
			vehicalDao.save(byId);

		} catch (Exception e) {
			LOGGER.error("Error assigning VehicalOwner: " + e.getMessage().toString());

		}
	}

}
