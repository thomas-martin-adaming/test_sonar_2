package com.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ferme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFerme;
	private String nom;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "ferme")
	private Set<Gerant> gerants = new HashSet<>();
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Departement departement;
	@OneToMany(mappedBy = "ferme")
	private Set<Animal> animaux = new HashSet<>();
	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	public Ferme() {
	}

	public Long getIdFerme() {
		return idFerme;
	}

	public void setIdFerme(Long idFerme) {
		this.idFerme = idFerme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Gerant> getGerants() {
		return gerants;
	}

	public void setGerants(Set<Gerant> gerants) {
		this.gerants = gerants;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Set<Animal> animaux) {
		this.animaux = animaux;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

}
