/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wijlens.vektis.domain;

/**
 *
 * @author Joris
 */
public class VersieStandaard {
    private final Standaard standaard;
    private String versie;
    private String subversie;

    public VersieStandaard(String standaardCode, String versie, String subversie) {
        this.standaard = new Standaard(standaardCode);
        this.versie = versie;
        this.subversie = subversie;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((standaard == null) ? 0 : standaard.hashCode());
		result = prime * result
				+ ((subversie == null) ? 0 : subversie.hashCode());
		result = prime * result + ((versie == null) ? 0 : versie.hashCode());
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
		VersieStandaard other = (VersieStandaard) obj;
		if (standaard == null) {
			if (other.standaard != null)
				return false;
		} else if (!standaard.equals(other.standaard))
			return false;
		if (subversie == null) {
			if (other.subversie != null)
				return false;
		} else if (!subversie.equals(other.subversie))
			return false;
		if (versie == null) {
			if (other.versie != null)
				return false;
		} else if (!versie.equals(other.versie))
			return false;
		return true;
	}
    
    public Standaard standaard(){
    	return standaard;
    }
    
    public String versie(){
    	return versie;
    }
    
    public String subversie(){
    	return subversie;
    }
}
