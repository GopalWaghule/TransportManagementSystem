package com.tms.mono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tms.mono.service.AssighnmentService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@RestController
@RequestMapping("/assign")
public class AssigningController {
	
	@Autowired
	private AssighnmentService assighnmentService;
	
	@PutMapping("/vehical")
	public ResponseEntity<String> assignVehicalToConsighnment(@RequestParam Long vehicalId, @RequestParam Long cid){	
		try {
			assighnmentService.assighnConsighnment(cid, vehicalId);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
