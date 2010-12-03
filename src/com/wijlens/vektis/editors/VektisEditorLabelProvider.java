package com.wijlens.vektis.editors;

import java.util.List;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.wijlens.vektis.domain.BerichtKnoop;
import com.wijlens.vektis.domain.GegevensElement;
import com.wijlens.vektis.domain.Record;

/**
 * 
 * @author joris
 *
 */
public class VektisEditorLabelProvider extends LabelProvider implements ITableLabelProvider{

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof Record){
			List<GegevensElement> elementen = ((Record)element).elementen();
			if(columnIndex < elementen.size()){
				return elementen.get(columnIndex).waarde();
			}else{
				return "";
			}
		}else{
			return (columnIndex + 1) + "";
		}
	}

}
