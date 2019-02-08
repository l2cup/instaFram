package controller.actions;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import main.Core;
import model.tree.ParameterModel;
import view.tree.Parameter;

public class ParameterDocumentListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		String text = "";

		try {
			text = e.getDocument().getDefaultRootElement().getDocument().getText(0,
					e.getDocument().getDefaultRootElement().getDocument().getLength());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

		if (Core.getInstance().getSelectedNode() instanceof Parameter && Core.getInstance().getSelectedNode() != null) {
			((ParameterModel) Core.getInstance().getSelectedNode().getNodeModel()).setValue(text);
		}

	}

}
