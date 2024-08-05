package com.tms.mono.model.dto;

import java.util.List;

import com.tms.mono.model.Vehical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicalOwnerDTO {

	private Long id;
	private String name;
	private List<String> mobile;
	private List<Vehical> vehicals;

}
