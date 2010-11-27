/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wijlens.vektis;

import java.io.InputStream;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Joris
 */
public class VektisConfigSheet {

    private final Sheet sheet;
    private int currentRowNumber = 11;

    VektisConfigSheet(InputStream configFile) {
        try {

            Workbook workbook = Workbook.getWorkbook(configFile);

            sheet = workbook.getSheet(1);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getLineId() {
        return cellValue(2, currentRowNumber);
    }

    public String getElementId() {
        return cellValue(3, currentRowNumber);
    }

    public String getElementName() {
        return cellValue(4, currentRowNumber);
    }

    public String getType(){
        return cellValue(5, currentRowNumber);
    }

    public String getElementLength() {
        return cellValue(6, currentRowNumber);
    }

    public String getElementEndPosition() {
        return cellValue(8, currentRowNumber);
    }

    protected String cellValue(final int currentColumn, final int rowNumber) {
        return sheet.getCell(currentColumn, rowNumber).getContents();
    }

    boolean hasNext() {
        return !"".equals(cellValue(0, currentRowNumber));
    }

    void next() {
        currentRowNumber++;
    }
}
