package com.inti.service.interfaces;

import com.inti.entities.Departement;

public interface IDepartementService extends IService<Departement> {
	Departement rechercherDepartementParNom(String nom);
}
