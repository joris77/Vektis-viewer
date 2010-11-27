/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;

import com.wijlens.vektis.domain.Bericht;
import com.wijlens.vektis.domain.BerichtDefinitie;
import com.wijlens.vektis.domain.BerichtDefinitieKnoop;
import com.wijlens.vektis.domain.BerichtKnoop;
import com.wijlens.vektis.domain.ElementRepository;
import com.wijlens.vektis.domain.GegevensElement;
import com.wijlens.vektis.domain.ElementDefinitie;
import com.wijlens.vektis.domain.Record;
import com.wijlens.vektis.domain.RecordDefinitie;
import com.wijlens.vektis.domain.BerichtKnoopIdentificatie;
import com.wijlens.vektis.domain.VersieStandaard;

/**
 *
 * @author Joris
 */
public class ExcelElementDefinitieRepository implements ElementRepository{

    

    

    

	@Override
	public LinkedHashMap<ElementIdentificatie, ElementDefinitie> zoekElementenVoorRecord(
			BerichtDefinitieKnoop recordDefinitie) {
		LinkedHashMap<ElementIdentificatie, ElementDefinitie> elementDefinities = new LinkedHashMap<ElementIdentificatie, ElementDefinitie>();
		for (VektisConfigSheet vcs = new VektisConfigSheet(Utils.getFile(recordDefinitie.berichtDefinitie().versieStandaard().getBestandsnaamConfiguratieBestand())); vcs.hasNext(); vcs.next()) {
            final String lineId = vcs.getLineId();
            if (new BerichtKnoopIdentificatie(lineId).equals(recordDefinitie.getId())) {
            }
            ElementIdentificatie elementIdentificatie = new ElementIdentificatie(vcs.getElementId());
            elementDefinities.put(elementIdentificatie, new ElementDefinitie(elementIdentificatie, vcs.getElementName(), vcs.getElementLength(), vcs.getElementEndPosition(), vcs.getType()));

        }
		return elementDefinities;
	}



	
}
