/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wijlens.vektis.domain;

/**
 *
 * @author Joris
 */
public class VektisType {
    private String name;

    public static VektisType NUMERIC = new VektisType("N");
    public static VektisType ALPHANUMERIC = new VektisType("AN");

    public VektisType(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VektisType other = (VektisType) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}
