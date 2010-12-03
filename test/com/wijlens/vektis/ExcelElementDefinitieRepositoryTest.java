package com.wijlens.vektis;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import com.wijlens.vektis.domain.BerichtDefinitieKnoop;
import com.wijlens.vektis.domain.BerichtKnoopIdentificatie;
import com.wijlens.vektis.domain.RecordDefinitie;
import com.wijlens.vektis.domain.VersieStandaard;

public class ExcelElementDefinitieRepositoryTest {
	
	private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	private ExcelElementDefinitieRepository repo;
	
	@Before
	public void setUp() throws Exception {
		repo = new ExcelElementDefinitieRepository();
	}

	@Test
	public void testZoekElementenVoorRecord() {
		final BerichtDefinitieKnoop recordDefinitie = context.mock(RecordDefinitie.class);
		
		context.checking(new Expectations(){
			{
				
				
				one(recordDefinitie).versieStandaard();
				will(returnValue(new VersieStandaard("176", "01", "03")));
				
				one(recordDefinitie).getId();
				will(returnValue(new BerichtKnoopIdentificatie("01")));
			}
		});
		
		repo.zoekElementenVoorRecord(recordDefinitie);
	}

}
