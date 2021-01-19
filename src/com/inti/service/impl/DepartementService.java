package com.inti.service.impl;

import com.inti.dao.interfaces.IDepartementDAO;
import com.inti.entities.Departement;
import com.inti.service.interfaces.IDepartementService;
import com.inti.utils.FactoryDAO;

public class DepartementService extends ManagerService<Departement> implements IDepartementService {
	private IDepartementDAO departementDAO = (IDepartementDAO) FactoryDAO.methodeFactory("b");
	@Override
	public Departement rechercherDepartementParNom(String nom) {
		return departementDAO.rechercherDepartementParNom(nom);
	}

}
