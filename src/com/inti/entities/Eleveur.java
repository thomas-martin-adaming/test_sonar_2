package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Eleveur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEleveur;
	private String nom;
	private int age;
	private boolean statut;
	@OneToMany(mappedBy = "eleveur")
	private Set<Animal> animaux = new HashSet<>();

	public Eleveur() {
	}

	public Long getIdEleveur() {
		return idEleveur;
	}

	public void setIdEleveur(Long idEleveur) {
		this.idEleveur = idEleveur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Set<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Set<Animal> animaux) {
		this.animaux = animaux;
	}

}
