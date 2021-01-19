package com.inti.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.inti.entities.Adresse;
import com.inti.entities.Departement;
import com.inti.entities.Ferme;
import com.inti.service.interfaces.IDepartementService;
import com.inti.service.interfaces.IFermeService;
import com.inti.utils.FactoryService;

@ManagedBean
@SessionScoped
public class FermeManagedBean {
	private Ferme ferme = new Ferme();
	private List<Ferme> listFermes = new ArrayList<Ferme>();
	private List<Departement> listDepartement = new ArrayList<Departement>();
	IFermeService fermeService = (IFermeService) FactoryService.methodeFactory("a");
	IDepartementService departementService = (IDepartementService) FactoryService.methodeFactory("b");

	public FermeManagedBean() {
		ferme = new Ferme();
		ferme.setAdresse(new Adresse());
	}

	public Ferme getFerme() {
		return ferme;
	}

	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}

	public List<Ferme> getListFermes() {
		listFermes = fermeService.findAll(Ferme.class);
		return listFermes;
	}

	public void setListFermes(List<Ferme> listFermes) {
		this.listFermes = listFermes;
	}

	public List<Departement> getListDepartement() {
		listDepartement = departementService.findAll(Departement.class);
		return listDepartement;
	}

	public void setListDepartement(List<Departement> listDepartement) {
		this.listDepartement = listDepartement;
	}

	public void enregistrerFerme() {
		try {
			fermeService.save(this.ferme);
			this.ferme = new Ferme();
			ferme.setAdresse(new Adresse());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Ferme ajouté avec succés", "txt"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ferme n'est pas ajouté à la Base de données", "txt"));
		}
	}

	public void supprimerFerme(Ferme ferme) {
		try {
			fermeService.remove(ferme);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression avec succés", "txt"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!!", "Suppression n'est pas effectuée"));
		}
	}

	public String edit(Ferme ferme) {
		this.ferme = ferme;
		return "update";
	}

	public String update() {
		try {
			fermeService.update(ferme);
			this.ferme = new Ferme();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour avec succés", "txt"));
			return "accueil?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "txt"));
			return "update";
		}
	}
}
