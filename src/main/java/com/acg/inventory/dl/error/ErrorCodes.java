package com.acg.inventory.dl.error;

public class ErrorCodes {
	public enum UnitOfMeasurementCode {
		DUPLICATE(1, "Duplicate Unit Of Measurement"), NULL(2, "Empty Unit Of Measurement"),
		INVALID(3, "Invalid Unit Of Measurement");
		private long code;
		private String value;

		private UnitOfMeasurementCode(long code, String message) {
			this.code = code;
			this.value = message;
		}

		public long getCode() {
			return code;
		}

		public void setCode(long code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	};
}
