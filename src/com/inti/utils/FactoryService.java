package com.inti.utils;

import com.inti.service.impl.BasseCourService;
import com.inti.service.impl.BetailService;
import com.inti.service.impl.DepartementService;
import com.inti.service.impl.EleveurService;
import com.inti.service.impl.FermeService;
import com.inti.service.impl.GerantService;

public class FactoryService {
public static Object methodeFactory(String a) {
	switch(a) {
	case "a": 
		return new FermeService();
	case "b": 
		return new DepartementService();
	case "c": 
		return new GerantService();
	case "d": 
		return new EleveurService();
	case "e": 
		return new BetailService();
	case "f": 
		return new BasseCourService();
	default:
		return null;
	}
}
}
