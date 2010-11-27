package com.wijlens.vektis.domain;

import java.util.LinkedHashMap;

import com.wijlens.vektis.ElementIdentificatie;

public interface ElementRepository {

	LinkedHashMap<ElementIdentificatie, ElementDefinitie> zoekElementenVoorRecord(
			BerichtDefinitieKnoop recordDefinitie);

}
