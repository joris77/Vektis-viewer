/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wijlens.vektis;

import java.io.InputStream;

/**
 *
 * @author Joris
 */
public class Utils {

    public static InputStream getFile(String name){
        return Utils.class.getClassLoader().getResourceAsStream(name);
    }
}
