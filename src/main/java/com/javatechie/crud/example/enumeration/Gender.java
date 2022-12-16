package com.javatechie.crud.example.enumeration;

public enum Gender {
	MALE("MALE"), FEMALE("FEMELE");

	private String gendervalue;

	Gender(String a) {
		this.gendervalue = a;
	}
	public String getGender() {
		return gendervalue;
	}

	public static Gender data(String value) {
	for (Gender gender : Gender.values()) {
        if (gender.gendervalue.equals(value)) {
            return gender;
        }
       

	}
	return null;
	}

	

}