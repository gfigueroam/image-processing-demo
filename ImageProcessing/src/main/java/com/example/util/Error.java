package com.example.util;

/**
 * Defines the different error that can be display, and the specific description for each one.
 * @author gloria.figueroa
 */
public enum Error {

	//Error code
	SYSTEM_ERROR(1, "An error has occurred on the system."),
	MANDATORY_PARAMETER_MISSING(2, "Mandatory parameter missing."),
	FILTER_ID_NOT_NUMERIC(3,"Error getting the filterId, parameter is not numeric."),
	MALFORMED_URL(4,"It was not possible to extract the image from the URL. Please verify.");
	

	private final int code;
	private final String description;

	/**
	 * Create the CodeDescription. 
	 * @param code code number.
	 * @param description description
	 */
	Error(final int code, final String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Return the description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Return the code.
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return code + ": " + description;
	}

}
