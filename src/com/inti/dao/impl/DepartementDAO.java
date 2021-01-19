package com.inti.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.inti.dao.interfaces.IDepartementDAO;
import com.inti.entities.Departement;
import com.inti.utils.HibernateUtility;

public class DepartementDAO extends ManagerDAO<Departement> implements IDepartementDAO {

	@Override
	public Departement rechercherDepartementParNom(String nom) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Criteria crit = s.createCriteria(Departement.class);
	    crit.add(Restrictions.eq("nom", nom));
		return (Departement) crit.uniqueResult();
	}

}
