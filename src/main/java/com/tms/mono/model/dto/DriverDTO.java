package com.tms.mono.model.dto;

import com.tms.mono.model.Vehical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTO {

	private Long id;
	private String name;
	private String mobile;
	private Vehical vehicals;

}
