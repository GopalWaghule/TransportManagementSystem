package com.tms.mono.model.dto;

import com.tms.mono.enums.Status;
import com.tms.mono.model.ConsighnmentOwner;
import com.tms.mono.model.Route;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsighnmentDTO {
	private Long id;
	private String type;
	private String destination;
	private ConsighnmentOwner consighnmentOwner;
	private Double loadWeight;
	private Double fare;
	private Status status;
	private Route route;

}
