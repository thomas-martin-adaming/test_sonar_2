package com.inti.utils;

import com.inti.dao.impl.BasseCourDAO;
import com.inti.dao.impl.BetailDAO;
import com.inti.dao.impl.DepartementDAO;
import com.inti.dao.impl.EleveurDAO;
import com.inti.dao.impl.FermeDAO;
import com.inti.dao.impl.GerantDAO;

public class FactoryDAO {
	public static Object methodeFactory(String a) {
		switch(a) {
		case "a": 
			return new FermeDAO();
		case "b": 
			return new DepartementDAO();
		case "c": 
			return new GerantDAO();
		case "d": 
			return new EleveurDAO();
		case "e": 
			return new BetailDAO();
		case "f": 
			return new BasseCourDAO();
		default:
			return null;
		}
	}
}
