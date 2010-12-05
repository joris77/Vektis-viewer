package com.wijlens.vektis.editors;

import java.util.List;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;

import com.wijlens.vektis.domain.GegevensElement;
import com.wijlens.vektis.domain.Record;

public class VektisEditorCellLabelProvider extends CellLabelProvider {
	
	TreeViewer treeViewer;
	private final TextEditor editor;

	public VektisEditorCellLabelProvider(TextEditor editor, TreeViewer treeViewer) {
		super();
		this.editor = editor;
		this.treeViewer = treeViewer;
	}

	public String getToolTipText(Object element) {
		
		return "";
	}
	
		
	 	/* (non-Javadoc)
	 	* @see org.eclipse.jface.viewers.ViewerLabelProvider#getTooltipShift(java.lang.Object)
	 	*/
	 	public Point getToolTipShift(Object object) {
	 	return new Point(5,5);
	 	}
	

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		String waarde = "";
		if (element instanceof Record) {
			List<GegevensElement> elementen = ((Record) element).elementen();
			if (cell.getColumnIndex() < elementen.size()) {
				waarde = elementen.get(cell.getColumnIndex()).waarde();
			}
		} else {
			waarde = cell.getColumnIndex() + 1 + "";
		}
		cell.setText(waarde);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerLabelProvider#getTooltipDisplayDelayTime
	 * (java.lang.Object)
	 */
	public int getToolTipDisplayDelayTime(Object object) {
		return 2000;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerLabelProvider#getTooltipTimeDisplayed
	 * (java.lang.Object)
	 */
	public int getToolTipTimeDisplayed(Object object) {
		return 5000;
	}

}
