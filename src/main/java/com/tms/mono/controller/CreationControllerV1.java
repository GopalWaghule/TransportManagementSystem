package com.tms.mono.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;
import com.tms.mono.service.CreateService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@RestController
@RequestMapping("/add/v1")
public class CreationControllerV1 {

	private static final Logger LOGGER = LogManager.getLogger(CreationControllerV1.class);

	private CreateService createService;

	private CreationControllerV1(CreateService createService) {
		super();
		this.createService = createService;
	}

	@PostMapping("/v")
	public ResponseEntity<Vehical> addVehical(@RequestBody Vehical vehical) {
		LOGGER.info("In <CreationControllerV1>");
		try {
			createService.addVehical(vehical);
			return ResponseEntity.ok(vehical);
		} catch (ValidationException v) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			// Handle other unexpected exceptions
			LOGGER.info("INTERNAL_SERVER_ERROR : " + e.getCause().toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/c")
	public ResponseEntity<Consighnment> addConsighnment(@RequestBody Consighnment consighnment) {

		try {
			LOGGER.info("In <CreationControllerV1>");
			createService.addConsighnment(consighnment);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			// Handle other unexpected exceptions
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/vo")
	public ResponseEntity<VehicalOwner> addVehicalOwner(@RequestBody VehicalOwner vehicalOwner) {
		try {
			LOGGER.info("In <CreationControllerV1>");
			createService.addVehicalOwner(vehicalOwner);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/d")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
		try {
			LOGGER.info("In <CreationControllerV1>");
			createService.addDriver(driver);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/r")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		try {
			LOGGER.info("In <CreationControllerV1>");
			createService.addRoute(route);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/co")
	public ResponseEntity<ConsighnmentOwner> addConsighnmentOwner(@RequestBody ConsighnmentOwner consighnmentOwner) {

		try {
			LOGGER.info("In <CreationControllerV1>");
			createService.addConsighnmentOwner(consighnmentOwner);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
