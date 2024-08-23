package com.tms.mono.exception;

public class VehicleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehicleNotFoundException(String number) {
		super("Vehical with number " + number + " not found.");
	}
}