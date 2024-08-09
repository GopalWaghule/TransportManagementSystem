package com.tms.mono.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.repository.ConsighnmentOwnerDao;
import com.tms.mono.repository.DriverDao;
import com.tms.mono.repository.RouteDao;
import com.tms.mono.repository.VehicalDao;
import com.tms.mono.repository.VehicalOwnerDao;
import com.tms.mono.service.CreateService;

import jakarta.transaction.Transactional;

@Service
public class CreateServiceImpl implements CreateService {

	private static final Logger LOGGER = LogManager.getLogger(CreateServiceImpl.class);

	private ConsighnmentDao consighnmentDao;

	private DriverDao driverDao;

	private RouteDao routeDao;

	private VehicalDao vehicalDao;

	private VehicalOwnerDao vehicalOwnerDao;

	private ConsighnmentOwnerDao consighnmentOwnerDao;


	public CreateServiceImpl(ConsighnmentDao consighnmentDao, DriverDao driverDao, RouteDao routeDao,
			VehicalDao vehicalDao, VehicalOwnerDao vehicalOwnerDao, ConsighnmentOwnerDao consighnmentOwnerDao) {
		super();
		this.consighnmentDao = consighnmentDao;
		this.driverDao = driverDao;
		this.routeDao = routeDao;
		this.vehicalDao = vehicalDao;
		this.vehicalOwnerDao = vehicalOwnerDao;
		this.consighnmentOwnerDao = consighnmentOwnerDao;
		
	}

	@Override
	public void addConsighnment(Consighnment consighnment) {

		LOGGER.info("Adding new Consighnment to the database : " + consighnment.toString());
		consighnment.setStatus(Status.Non_Active);
		consighnmentDao.save(consighnment);
		LOGGER.info("New Consighnment added with {Non_Active} status ..........");

	}

	@Override
	public void addDriver(Driver driver) {
		LOGGER.info("Adding new Driver to the database : " + driver.toString());
		driverDao.save(driver);
		LOGGER.info("New Driver added..........");
	}

	@Override
	public void addRoute(Route route) {
		LOGGER.info("Adding new Route to the database : " + route.toString());
		routeDao.save(route);
		LOGGER.info("New Route added..........");
	}

	@Override
	@Transactional
	public void addVehical(Vehical vehical) {
		LOGGER.info("Adding new Vehical Owner to the database : " + vehical.getOwner().toString());
		vehicalOwnerDao.save(vehical.getOwner());
		LOGGER.info("Vehical Owner Added");
		LOGGER.info("Adding new Vehical to the database ......... ");
		vehicalDao.save(vehical);
		LOGGER.info("..............................................");
		LOGGER.info("Vehical Added : " + vehical.toString());
	}

	@Override
	public void addVehicalOwner(VehicalOwner owner) {
		LOGGER.info("Adding new VehicalOwner to the database : " + owner.toString());
		vehicalOwnerDao.save(owner);
		LOGGER.info("New Vehical Owner added..........");
	}

	@Override
	public void addConsighnmentOwner(ConsighnmentOwner consighnmentOwner) {
		LOGGER.info("Adding new ConsighnmentOwner to the database : " + consighnmentOwner.toString());
		consighnmentOwnerDao.save(consighnmentOwner);
		LOGGER.info("New ConsighnmentOwner added..........");
	}	
}
