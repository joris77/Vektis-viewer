package com.wijlens.vektis.domain;

/**
 * 
 * @author joris
 *
 */
public interface GegevensElementListener {

	void wijziging(GegevensElement gegevensElement, String oldValue,
			String newValue);

}
