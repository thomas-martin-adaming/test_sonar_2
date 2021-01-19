package com.inti.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bc")
public class BasseCour extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String habitat;

	public BasseCour() {
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

}
