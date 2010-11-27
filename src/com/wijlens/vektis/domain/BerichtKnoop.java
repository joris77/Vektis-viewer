package com.wijlens.vektis.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Vektis bestanden zijn bomen dit is het concept knoop in die boomstructuur.
 * 
 * @author joris
 *
 */
public abstract class BerichtKnoop {
	
	
	protected BerichtKnoop ouder;
	
	private List<Record> kinderen = new ArrayList<Record>();
	
	public BerichtKnoop ouder(){
		return ouder;
	}
	
	
	public List<Record> kinderen(){
		return kinderen;
	}
	
	public void voegKindToe(Record kind){
		kinderen.add(kind);
	}


	public abstract BerichtDefinitieKnoop berichtDefinitieKnoop();


	protected BerichtKnoopIdentificatie id(String regel) {
		return new BerichtKnoopIdentificatie(regel.substring(0, 2));
	}


	protected void voegToeAanLijst(List<Record> list) {
		for (Record kind : kinderen()) {
			kind.voegToeAanLijst(list);
		}
	}


	
}
