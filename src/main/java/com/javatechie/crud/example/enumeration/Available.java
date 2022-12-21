package com.javatechie.crud.example.enumeration;

public enum Available {
	YES("YES"), NO("NO");

	private String available1;

	Available(String a) {
		this.available1 = a;
	}

	public String getAvailable() {
		return available1;
	}

	public static Available data(String value) {
		for (Available num : Available.values()) {
			if (num.available1.equals(value)) {
				return num;
			}

		}
		return null;
	}

}
