package com.tms.mono.model.dto;

import java.time.LocalDate;


import com.tms.mono.enums.Status;
import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Vehical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignedConsighnmentsDetailsDTO {
	private Long id;
	private Consighnment consighnment;
	private Vehical vehical;
	private Double totalFair;
	private Double advance;
	private Double remainingFair;
	private Status status;
	private LocalDate startDate;

}
