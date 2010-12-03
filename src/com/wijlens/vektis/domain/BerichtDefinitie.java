/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wijlens.vektis.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Joris
 */
public class BerichtDefinitie extends BerichtDefinitieKnoop{
	
	public BerichtDefinitie(VersieStandaard versieStandaard) {
		super();
		this.id = new BerichtKnoopIdentificatie("DOCUMENT");
		this.versieStandaard = versieStandaard;
		
		maakStandaardVektisBerichtStructuur();
	}

	private void maakStandaardVektisBerichtStructuur() {
    	new RecordDefinitie(BerichtKnoopIdentificatie.VOORLOOP_RECORD, this);
    	BerichtDefinitieKnoop verzekerdenRecordDefinitie = new RecordDefinitie(BerichtKnoopIdentificatie.VERZEKERDE_RECORD, this);
    	new RecordDefinitie(BerichtKnoopIdentificatie.COMMENTAAR_RECORD, verzekerdenRecordDefinitie);
    	BerichtDefinitieKnoop debiteurRecordDefinitie = new RecordDefinitie(BerichtKnoopIdentificatie.DEBITEUR_RECORD, verzekerdenRecordDefinitie);
    	new RecordDefinitie(BerichtKnoopIdentificatie.COMMENTAAR_RECORD, debiteurRecordDefinitie);
    	BerichtDefinitieKnoop prestatieRecordDefinitie = new RecordDefinitie(BerichtKnoopIdentificatie.PRESTATIE_RECORD, verzekerdenRecordDefinitie);
    	new RecordDefinitie(BerichtKnoopIdentificatie.COMMENTAAR_RECORD, prestatieRecordDefinitie);
    	new RecordDefinitie(BerichtKnoopIdentificatie.SLUIT_RECORD, this);
	}
    
    public BerichtDefinitieKnoop getLineConfig(BerichtKnoopIdentificatie lineId) {
        return kinderen.get(lineId);
    }

	public List<RecordDefinitie> alleRecordDefinities() {
		List<RecordDefinitie> list = new ArrayList<RecordDefinitie>();
		voegToeAanLijst(list);
		return list;
	}

	@Override
	public BerichtDefinitie berichtDefinitie() {
		return this;
	}

	public VersieStandaard versieStandaard(){
		return this.versieStandaard;
	}
	

	
    
}
