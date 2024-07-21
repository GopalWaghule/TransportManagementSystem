package com.tms.mono.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.mono.enums.Status;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.service.FetchService;

@Service
public class FetchServiceImpl implements FetchService {

	@Autowired
	private ConsighnmentDao consighnmentDao;
	
	@Override
	public List<Consighnment> findAllActiveConsighnment() {	
			return consighnmentDao.findByStatus(Status.ACTIVE);
	}

	@Override
	public List<Consighnment> findAllActiveConsighnmentByRoute(Route route) {
		return consighnmentDao.findByStatusAndRoute(Status.ACTIVE, route);
		
	}

}
