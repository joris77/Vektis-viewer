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
public class ElementDefinitie {

    private final ElementIdentificatie elementIdentificatie;
    private final String naam;
    private final int lengte;
    private final int eindpositie;
    private VektisType type;

    public ElementDefinitie(ElementIdentificatie elementIdentificatie, String name, String length, String endPosition, String type) {
        this.elementIdentificatie = elementIdentificatie;
        this.naam = name;
        this.lengte = Integer.parseInt(length);
        this.eindpositie = Integer.parseInt(endPosition);
        this.type = new VektisType(type);
    }

    public ElementIdentificatie elementIdentificatie() {
        return elementIdentificatie;
    }

    public int getLengte() {
        return lengte;
    }

    public String getNaam() {
        return naam;
    }

    public int getEindPositie() {
        return eindpositie;
    }

    public int getBeginPositie(){
        return eindpositie - lengte;
    }

    public VektisType getType() {
        return type;
    }

    public String correctSize(String newValue) {
        if (newValue.length() > getLengte()) {
            return StringUtils.substring(newValue, 0, getLengte());
        }
        if (newValue.length() < getLengte()) {
            if (getType().equals(VektisType.NUMERIC)) {
                return StringUtils.leftPad(newValue, getLengte(), "0");
            } else {
                return StringUtils.rightPad(newValue, getLengte(), " ");
            }
        }
        return newValue;
    }
    
    public String toString(){
    	return elementIdentificatie.toString();
    }
}
