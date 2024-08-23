package com.tms.mono.exception;

public class VehicalOwnerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VehicalOwnerNotFoundException(Long ownerId) {
		super("Owner with ID " + ownerId + " not found.");
	}

}
