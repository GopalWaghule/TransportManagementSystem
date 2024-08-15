package com.tms.mono.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tms.mono.model.dto.AssignedConsighnmentsDetailsDTO;
import com.tms.mono.service.AssighnmentService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@RestController
@RequestMapping("/assign")
public class AssigningController {

	private static final Logger LOGGER = LogManager.getLogger(AssigningController.class);

	private AssighnmentService assighnmentService;
	

	private AssigningController(AssighnmentService assighnmentService, ModelMapper modelMapper) {
		super();
		this.assighnmentService = assighnmentService;
		
	}

	@PutMapping("/vehical")
	public ResponseEntity<String> assignVehicalToConsighnment(@RequestParam Long vehicalId, @RequestParam Long cid) {
		LOGGER.info("In AssigningController -> assignVehicalToConsighnment ");
		try {
			assighnmentService.assighnConsighnment(cid, vehicalId);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/vehicalOwner")
	public ResponseEntity<String> assighnVehicalOwnerToVehical(@RequestParam String vehicalNumber,
			@RequestParam Long voId) {

		LOGGER.info("In AssigningController -> assignVehicalToConsighnment ");
		try {
			assighnmentService.assighnVehicalOwnerToVehical(vehicalNumber, voId);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			LOGGER.info(e.getStackTrace().toString());
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/assignConsighnment")
	public ResponseEntity<AssignedConsighnmentsDetailsDTO> assighnConsighnment(@RequestParam Long consigId,@RequestParam Long vehicalId) {

		LOGGER.info("In AssigningController -> assignConsighnment ");
		try {
			assighnmentService.assighnConsighnment(consigId, vehicalId);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			LOGGER.info(e.getStackTrace().toString());
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
