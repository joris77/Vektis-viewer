package com.wijlens.vektis.domain;

/**
 * 
 * Value object 
 * 
 * @author joris
 *
 */
public class BerichtKnoopIdentificatie {
	
	public final static BerichtKnoopIdentificatie VOORLOOP_RECORD = new BerichtKnoopIdentificatie("01");
	public final static BerichtKnoopIdentificatie VERZEKERDE_RECORD = new BerichtKnoopIdentificatie("02");
	public final static BerichtKnoopIdentificatie DEBITEUR_RECORD = new BerichtKnoopIdentificatie("03");
	public final static BerichtKnoopIdentificatie PRESTATIE_RECORD = new BerichtKnoopIdentificatie("04");
	public final static BerichtKnoopIdentificatie COMMENTAAR_RECORD = new BerichtKnoopIdentificatie("98");
	public final static BerichtKnoopIdentificatie SLUIT_RECORD = new BerichtKnoopIdentificatie("99");

	private String id;

	public BerichtKnoopIdentificatie(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BerichtKnoopIdentificatie other = (BerichtKnoopIdentificatie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecordIdentificatie [id=" + id + "]";
	}
	
	
}
