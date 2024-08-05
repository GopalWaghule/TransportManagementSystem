package com.tms.mono.model.dto;

import java.util.List;

import com.tms.mono.model.AssignedConsighnmentsDetails;
import com.tms.mono.model.Driver;
import com.tms.mono.model.Route;
import com.tms.mono.model.VehicalOwner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicalDTO {

	private Long id;
	private String number;
	private String maker;
	private String model;
	private Double totalCapacity;
	private Double remainingCapacity;
	private VehicalOwner owner;
	private List<Driver> drivers;
	private Route route;
	private AssignedConsighnmentsDetails assighnment;

}
