package com.tms.mono.service;

import org.springframework.stereotype.Service;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;

@Service
public interface CreateService {

	void addConsighnment(Consighnment consighnment);

	void addDriver(Driver driver);

	void addRoute(Route route);

	void addVehical(Vehical vehical);

	void addVehicalOwner(VehicalOwner owner);

	void addConsighnmentOwner(ConsighnmentOwner consighnmentOwner);

}
