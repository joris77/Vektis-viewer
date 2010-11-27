package com.wijlens.vektis.domain;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BerichtDefinitieKnoop {

	protected VersieStandaard versieStandaard;
	protected BerichtDefinitieKnoop ouder;
	protected Map<BerichtKnoopIdentificatie, RecordDefinitie> kinderen = new LinkedHashMap<BerichtKnoopIdentificatie, RecordDefinitie>();
	protected BerichtKnoopIdentificatie id;
	
	public void voegKindToe(RecordDefinitie kind){
		kinderen.put(kind.getId(), kind);
	}

	

	public BerichtKnoopIdentificatie getId() {
	    return id;
	}



	public RecordDefinitie recordDefinitie(BerichtKnoopIdentificatie berichtKnoopIdentificatie) {
		for (RecordDefinitie kind : kinderen.values()) {
			RecordDefinitie recordDefinitie = kind.recordDefinitie(berichtKnoopIdentificatie);
			if(recordDefinitie != null){
				return recordDefinitie;
			}
		}
		return null;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ouder == null) ? 0 : ouder.hashCode());
		result = prime * result
				+ ((versieStandaard == null) ? 0 : versieStandaard.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BerichtDefinitieKnoop other = (BerichtDefinitieKnoop) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ouder == null) {
			if (other.ouder != null)
				return false;
		} else if (!ouder.equals(other.ouder))
			return false;
		if (versieStandaard == null) {
			if (other.versieStandaard != null)
				return false;
		} else if (!versieStandaard.equals(other.versieStandaard))
			return false;
		return true;
	}



	public abstract BerichtDefinitie berichtDefinitie();

}
