/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wijlens.vektis.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.wijlens.vektis.ElementIdentificatie;

/**
 * 
 * @author Joris
 */
public class Record extends BerichtKnoop {

	private Map<ElementIdentificatie, GegevensElement> gegevensElementen = new LinkedHashMap<ElementIdentificatie, GegevensElement>();

	private RecordDefinitie recordDefinitie;

	public Record(BerichtKnoop ouder, RecordDefinitie recordDefinitie,
			String regel) {
		this.recordDefinitie = recordDefinitie;
		this.ouder = ouder;
		ouder.voegKindToe(this);

		for (final ElementDefinitie elementDefinitie : recordDefinitie
				.elementDefinities()) {
			String value = null;
			try {
				value = regel.substring(elementDefinitie.getBeginPositie(),
						elementDefinitie.getEindPositie());
			} catch (StringIndexOutOfBoundsException e) {
				value = elementDefinitie.correctSize("");
			}
			add(new GegevensElement(elementDefinitie, value));
		}
	}

	void add(GegevensElement gegevensElement) {
		gegevensElementen.put(gegevensElement.getId(), gegevensElement);
	}

	public GegevensElement getElement(int index) {
		return (GegevensElement) getElementen().toArray()[index];
	}

	public Collection<GegevensElement> getElementen() {
		return gegevensElementen.values();
	}

	int getNumberOfLineElements() {
		return recordDefinitie.aantalElementen();
	}

	public boolean isOuderVan(String regel) {
		return recordDefinitie.kinderen.keySet().contains(id(regel));
	}
	
	public boolean isBroertjeVan(String regel) {
		return ouder == null ? null : recordDefinitie.ouder.equals(recordDefinitie.berichtDefinitie().recordDefinitie(id(regel)).ouder);
	}

	@Override
	public String toString() {
		return recordDefinitie.toString();
	}

	@Override
	public BerichtDefinitieKnoop berichtDefinitieKnoop() {
		return recordDefinitie;
	}

	@Override
	public void voegToeAanLijst(List<Record> list) {
		list.add(this);
		super.voegToeAanLijst(list);
	}

	

	
	
	
}
