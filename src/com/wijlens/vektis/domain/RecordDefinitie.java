/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.internal.commands.ElementReference;

import com.wijlens.vektis.ElementIdentificatie;

/**
 *
 * @author Joris
 */
public class RecordDefinitie extends BerichtDefinitieKnoop{

    private LinkedHashMap<ElementIdentificatie, ElementDefinitie> elementDefinities;

    public RecordDefinitie(BerichtKnoopIdentificatie id, BerichtDefinitieKnoop ouder) {
        this.id = id;
        this.ouder = ouder;
        this.ouder.voegKindToe(this);
        this.elementDefinities = Fabriek.maak(ElementRepository.class).zoekElementenVoorRecord(this);
    }

    public Collection<ElementDefinitie> elementDefinities() {
        return elementDefinities.values();
    }

    int aantalElementen() {
        return elementDefinities.values().size();
    }

	public RecordDefinitie recordDefinitie(BerichtKnoopIdentificatie berichtKnoopIdentificatie) {
		if(berichtKnoopIdentificatie.equals(id)){
			return this;
		}
		return super.recordDefinitie(berichtKnoopIdentificatie);
	}

	@Override
	public BerichtDefinitie berichtDefinitie() {
		return ouder.berichtDefinitie();
	}

	@Override
	public String toString() {
		return this.id.toString();
	}
	
	@Override
	public void voegToeAanLijst(List<RecordDefinitie> list) {
		list.add(this);
		super.voegToeAanLijst(list);
	}

	
	
}
