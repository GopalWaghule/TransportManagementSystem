package com.tms.mono.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/add/v2")
public class CreateControllerV2 {

	@Autowired
	private CreateService createService;

	@PostMapping
	private ResponseEntity<?> add(@RequestBody(required = false) Vehical vehical,
			@RequestBody(required = false) VehicalOwner vehicalOwner,
			@RequestBody(required = false) Consighnment consighnment,
			@RequestBody(required = false) ConsighnmentOwner consighnmentOwner,
			@RequestBody(required = false) Route route, 
			@RequestBody(required = false) Driver driver) {
		try {

			if (vehical != null) {
				createService.addVehical(vehical);
				return ResponseEntity.ok().build();
			} else if (consighnment != null) {
				createService.addConsighnment(consighnment);
				return ResponseEntity.ok().build();
			} else if (consighnmentOwner != null) {
				createService.addConsighnmentOwner(consighnmentOwner);
				return ResponseEntity.ok().build();
			} else if (driver != null) {
				createService.addDriver(driver);
				return ResponseEntity.ok().build();
			} else if (route != null) {
				createService.addRoute(route);
				return ResponseEntity.ok().build();
			} else if (vehicalOwner != null) {
				createService.addVehicalOwner(vehicalOwner);
				return ResponseEntity.ok().build();
			} else {
				String errorMessage = "No Body Passed";
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errorMessage);
			}
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
