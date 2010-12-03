package com.wijlens.vektis.editors;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.wijlens.vektis.domain.BerichtKnoop;

/**
 * 
 * @author joris
 *
 */
public class VektisEditorContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return berichtKnoop(parentElement).kinderen().toArray();
	}

	private BerichtKnoop berichtKnoop(Object parentElement) {
		return ((BerichtKnoop)parentElement);
	}

	@Override
	public Object getParent(Object element) {
		return berichtKnoop(element).ouder();
	}

	@Override
	public boolean hasChildren(Object element) {
		return !berichtKnoop(element).kinderen().isEmpty();
	}

}
