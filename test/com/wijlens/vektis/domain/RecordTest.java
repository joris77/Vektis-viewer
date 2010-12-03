package com.wijlens.vektis.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wijlens.vektis.Utils;

public class RecordTest {
	
	
	@Test
	public void testIsBroertjeVan() {
		BerichtDefinitie berichtDefinitie = new BerichtDefinitie(new VersieStandaard("MZ301", "01", "03"));
		RecordDefinitie recordDefinitie = new RecordDefinitie(new BerichtKnoopIdentificatie("99"), berichtDefinitie);
		String regel = "02";
		Bericht bericht = new Bericht(Utils.getFile("MZ301.asc"));
		Record voorloopRecord = new Record(bericht, recordDefinitie, regel);
		voorloopRecord.isBroertjeVan(regel);
	}

}
