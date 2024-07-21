package com.tms.mono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.VehicalOwner;
import com.tms.mono.service.CreateService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@Controller
@RequestMapping("/add/v1")
public class CreationControllerV1 {

	@Autowired
	private CreateService createService;

	@PostMapping("/v")
	public ResponseEntity<Vehical> addVehical(@RequestBody Vehical vehical) {
		try {
			createService.addVehical(vehical);
			return ResponseEntity.ok(vehical);
		} catch (ValidationException v) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			// Handle other unexpected exceptions
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/c")
	public ResponseEntity<Consighnment> addConsighnment(@RequestBody Consighnment consighnment) {

		try {
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
	private ResponseEntity<VehicalOwner> addVehicalOwner(@RequestBody VehicalOwner vehicalOwner) {
		try {
			createService.addVehicalOwner(vehicalOwner);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/d")
	private ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
		try {
			createService.addDriver(driver);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/r")
	private ResponseEntity<Route> addRoute(@RequestBody Route route) {
		try {
			createService.addRoute(route);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/co")
	private ResponseEntity<ConsighnmentOwner> addConsighnmentOwner(@RequestBody ConsighnmentOwner consighnmentOwner) {

		try {
			createService.addConsighnmentOwner(consighnmentOwner);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
