package com.wijlens.vektis.domain;

import com.wijlens.vektis.ExcelElementDefinitieRepository;

/**
 * 
 * Bordello pattern
 * 
 * @author joris
 *
 */
public class Fabriek {
	public static <T> T maak(Class<T> clazz) {
		return (T) new ExcelElementDefinitieRepository();
	}
}
