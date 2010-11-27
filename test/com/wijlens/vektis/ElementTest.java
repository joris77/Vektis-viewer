package com.wijlens.vektis;

import junit.framework.Assert;

import org.junit.Test;

import com.wijlens.vektis.domain.GegevensElement;
import com.wijlens.vektis.domain.ElementDefinitie;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Joris
 */
public class ElementTest {

    GegevensElement gegevensElement;

    ElementDefinitie elementDefinitie;

    /**
     * Test of correctSize method, of class Element.
     */
    @Test
    public void testCorrectSize() {
        elementDefinitie = new ElementDefinitie(null, null, "1", "1", null);
        gegevensElement = new GegevensElement(elementDefinitie, "d");
        
        String result = gegevensElement.correctSize("dd");
        Assert.assertEquals(result,"d");
    }

}