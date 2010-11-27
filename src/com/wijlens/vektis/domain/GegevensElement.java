/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis.domain;

import org.apache.commons.lang.StringUtils;

import com.wijlens.vektis.ElementIdentificatie;

/**
 *
 * @author Joris
 */
public class GegevensElement {

    private final ElementDefinitie elementDefinitie;
    public String value;

    public String getValue() {
        return value;
    }

    GegevensElement(ElementDefinitie lineElementConfig, String value) {
        this.elementDefinitie = lineElementConfig;
        this.value = value;
    }

    public ElementIdentificatie getId() {
        return elementDefinitie.elementIdentificatie();
    }

    public void setValue(String aValue) {
        this.value = aValue;
    }

    public String getLabel() {
        return elementDefinitie.elementIdentificatie() + " " + elementDefinitie.getNaam();
    }

    public int getLength() {
        return elementDefinitie.getLengte();
    }

    public VektisType getType() {
        return elementDefinitie.getType();
    }

    public String correctSize(String newValue) {
        return elementDefinitie.correctSize(newValue);
    }

    

    public boolean isValid(String value) {
        if(VektisType.NUMERIC.equals(elementDefinitie.getType()) && !StringUtils.isNumeric(value)){
            return false;
        }else{
            return true;
        }
    }
    
    public String toString(){
    	return elementDefinitie + " " + value;
    }
}
