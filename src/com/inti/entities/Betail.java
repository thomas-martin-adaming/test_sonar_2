package com.inti.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "b")
public class Betail extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String techElevage;

	public Betail() {
	}

	public String getTechElevage() {
		return techElevage;
	}

	public void setTechElevage(String techElevage) {
		this.techElevage = techElevage;
	}

}
