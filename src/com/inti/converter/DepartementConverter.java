package com.inti.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.inti.entities.Departement;
import com.inti.service.interfaces.IDepartementService;
import com.inti.utils.FactoryService;

@FacesConverter("deptConverter")
public class DepartementConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null && arg2.trim().length() > 0) {
			try {
				IDepartementService departementService = (IDepartementService) FactoryService.methodeFactory("b");
				return departementService.rechercherDepartementParNom(arg2);
			} catch (NumberFormatException ex) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid value"));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {

			return String.valueOf(((Departement) arg2).getNom());
		} else {
			return null;
		}
	}

}
