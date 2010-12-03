/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.wijlens.vektis.ElementIdentificatie;

/**
 *
 * @author Joris
 */
public class GegevensElement {

    private final ElementDefinitie elementDefinitie;
    private String waarde;
    private List<GegevensElementListener> listeners = new ArrayList<GegevensElementListener>();
	private final Record record;

    public String waarde() {
        return waarde;
    }

    GegevensElement(Record record,ElementDefinitie elementDefinitie, String value) {
        this.record = record;
		this.elementDefinitie = elementDefinitie;
        this.waarde = value;
    }

    public ElementIdentificatie id() {
        return elementDefinitie.elementIdentificatie();
    }

    public void wijzig(String newValue) {
    	String oldValue = this.waarde;
        this.waarde = newValue;
        for (GegevensElementListener listener : listeners) {
			listener.wijziging(this,oldValue, newValue);
		}
    }

    public String label() {
        return elementDefinitie.elementIdentificatie() + " " + elementDefinitie.getNaam();
    }

    public int lengte() {
        return elementDefinitie.getLengte();
    }

    public VektisType type() {
        return elementDefinitie.type();
    }

    public String corrigeerLengte(String newValue) {
        return elementDefinitie.correctSize(newValue);
    }

    

    public boolean isGeldig(String value) {
        if(VektisType.NUMERIC.equals(elementDefinitie.type()) && !StringUtils.isNumeric(value)){
            return false;
        }else{
            return true;
        }
    }
    
    public String toString(){
    	return elementDefinitie + " " + waarde;
    }
    
    public void addListener(GegevensElementListener gegevensElementListener){
    	listeners.add(gegevensElementListener);
    }

	public Record record() {
		return record;
	}
}
