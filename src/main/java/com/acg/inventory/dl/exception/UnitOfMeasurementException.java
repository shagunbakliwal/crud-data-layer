package com.acg.inventory.dl.exception;

public class UnitOfMeasurementException extends Exception {
	private long errorCode;

	public UnitOfMeasurementException(long errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}

}
