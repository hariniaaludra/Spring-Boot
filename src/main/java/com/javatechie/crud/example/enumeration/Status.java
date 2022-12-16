package com.javatechie.crud.example.enumeration;

public enum Status {

	ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private String value;

	Status(String a) {
		this.value = a;
	}

	public String getGender() {
		return value;
	}
	public static Status data(String ser) {
		for (Status status : Status.values()) {
	        if (status.value.equals(ser)) {
	            return status;
	        }
	       

		}
		return null;
		}
}

