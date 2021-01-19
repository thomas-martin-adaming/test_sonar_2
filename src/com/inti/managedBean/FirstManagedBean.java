package com.inti.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
/*
 * @ApplicationScoped : la portée de l'application
 * 
 * @SessionScoped : la portée d'une session
 * 
 * @ViewScoped : la portée sur une seule page web
 * 
 * @RequestScoped : la portée avec requête (par défaut)
 */
public class FirstManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;

	public FirstManagedBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String seConnecter() {
		if(this.login.equals("admin") && this.password.equals("admin")) {
			return "accepted";
		}
		else {
			return "rejected";
		}
	}
}
