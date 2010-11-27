/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joris
 */
public class Standaard {

    {
        standaardNamen.put("106", "AP304");
        standaardNamen.put("120", "AP304");
        standaardNamen.put("143", "AP305");
        standaardNamen.put("144", "AP305");
        standaardNamen.put("176", "MZ301");
        standaardNamen.put("177", "MZ302");
        standaardNamen.put("179", "EP301");
        standaardNamen.put("180", "EP302");
    }
    private static Map<String, String> standaardNamen = new HashMap<String, String>();
    private final String standaardCode;

    public Standaard(String codeExterneIntegratieBericht) {
        this.standaardCode = getStandaardNaamVoorCode(codeExterneIntegratieBericht);
    }

    public String getStandaardNaamVoorCode(String code) {
        return standaardNamen.get(code);
    }

    public String getStandaardCode() {
        return standaardCode;
    }
}
