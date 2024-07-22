package com.tms.mono.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.service.FetchService;

@Service
public class FetchServiceImpl implements FetchService {
	
	private static final Logger LOGGER= LogManager.getLogger(FetchServiceImpl.class);

	@Autowired
	private ConsighnmentDao consighnmentDao;

	@Override
	public List<Consighnment> findAllActiveConsighnment() {
		LOGGER.info("Finding Consighnment by ACTIVE status ");
		return consighnmentDao.findByStatus(Status.ACTIVE);
	}

	@Override
	public List<Consighnment> findAllActiveConsighnmentByRoute(Route route) {
		LOGGER.info("Finding Consighnment by ACTIVE status and route");
		return consighnmentDao.findByStatusAndRoute(Status.ACTIVE, route);

	}

}
