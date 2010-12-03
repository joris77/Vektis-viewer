package com.wijlens.vektis.editors;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeItem;

import com.wijlens.vektis.domain.GegevensElement;
import com.wijlens.vektis.domain.Record;

public class VektisEditorCellModifier implements ICellModifier {

	private VektisEditor vektisEditor;

	public VektisEditorCellModifier(VektisEditor vektisEditor,
			TreeViewer treeViewer) {
		this.vektisEditor = vektisEditor;
	}

	@Override
	public boolean canModify(Object element, String property) {
		return element instanceof Record;
	}

	@Override
	public Object getValue(Object element, String property) {
		if (element instanceof Record) {
			return ((Record) element).element(Integer.parseInt(property)).waarde();
		}
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if (value != null && element instanceof TreeItem) {
			TreeItem treeItem = (TreeItem)element;
			((Record) treeItem.getData()).element(Integer.parseInt(property)).wijzig((String) value);
		}
	}

}
