package com.wijlens.vektis;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;

import com.wijlens.vektis.domain.BerichtDefinitie;
import com.wijlens.vektis.domain.BerichtKnoop;


/**
 *
 * @author Joris
 */
public class ParserTest {

    /**
     * Test of parseConfig method, of class Parser.
     */
    @Test
    public void testParseConfig() {
        System.out.println("parseConfig");
        InputStream configFile = Utils.getFile("MZ301V0103.xls");
        ExcelElementDefinitieRepository instance = new ExcelElementDefinitieRepository();
        BerichtDefinitie result = instance.parseConfig(configFile);
        Assert.assertNotNull(result.getLineConfig("02"));
    }

    /**
     * Test of parse method, of class Parser.
     */
    @Test
    public void testParse() {
        ExcelElementDefinitieRepository instance = new ExcelElementDefinitieRepository();
        BerichtKnoop bericht = instance.parse(Utils.getFile("MZ301.asc"));
        Assert.assertEquals(4, bericht.kinderen().size());
    }

}