/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;

import com.wijlens.vektis.Utils;

/**
 * 
 * @author Joris
 */
public class Bericht extends BerichtKnoop {

	private BerichtDefinitie berichtDefinitie;

	public Bericht(InputStream berichtBestand) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				berichtBestand));
		maakBericht(reader);
	}
	
	public Bericht(String bericht) {
		BufferedReader reader = new BufferedReader(new StringReader(
				bericht));
		maakBericht(reader);
	}

	private void maakBericht(BufferedReader reader) {
		try {
			Stack<BerichtKnoop> ouder = new Stack<BerichtKnoop>();
			ouder.push(this);

			String regel = reader.readLine();

			VersieStandaard versieStandaard = new VersieStandaard(
					regel.substring(2, 5), regel.substring(5, 7),
					regel.substring(7, 9));

			this.berichtDefinitie = new BerichtDefinitie(versieStandaard);

			while (regel != null) {

				RecordDefinitie recordDefinitie = this.berichtDefinitie
						.recordDefinitie(id(regel));

				Record record = new Record(ouder.peek(), recordDefinitie, regel);

				regel = reader.readLine();
				if (regel != null) {
					if (record.isOuderVan(regel)) {
						ouder.push(record);
					} else if (!record.isBroertjeVan(regel)) {
						while(!ouder.peek().berichtDefinitieKnoop().equals(berichtDefinitie.recordDefinitie(id(regel)).ouder))
						ouder.pop();
					}
				}
			}

		} catch (IOException ex) {
			throw new RuntimeException();
		}
	}

	public int getMaxLineSize() {
		int max = 0;
		for (RecordDefinitie recordDefinitie : berichtDefinitie
				.alleRecordDefinities()) {
			if (recordDefinitie.aantalElementen() > max) {
				max = recordDefinitie.aantalElementen();
			}
		}
		return max;
	}

	
	public List<Record> alleRecords() {
		List<Record> list = new ArrayList<Record>();
		voegToeAanLijst(list);
		return list;
	}

	@Override
	public BerichtDefinitieKnoop berichtDefinitieKnoop() {
		return berichtDefinitie;
	}
	
	public String parse() {
	        List<String> recordAlsTekst = new ArrayList<String>();

	        for (final Record line : alleRecords()) {
	            StringBuilder recordTekst = new StringBuilder("");
	            for (GegevensElement gegevensElement : line.elementen()) {
	                String value = gegevensElement.waarde();

	                recordTekst.append(value);
	            }
	            recordAlsTekst.add(recordTekst.toString());
	        }

	        String berichtInhoud = StringUtils.join(recordAlsTekst, "\n");

	        System.out.println("Bericht text \n" + berichtInhoud);

	        return berichtInhoud;
	    
	}
	
	public void addListener(GegevensElementListener listener){
		for (Record record : alleRecords()) {
			for (GegevensElement element : record.elementen()) {
				element.addListener(listener);
			}
		}
	}

}
