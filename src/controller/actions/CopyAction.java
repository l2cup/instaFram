package controller.actions;

import java.awt.event.ActionEvent;

import javafx.scene.Node;
import main.Core;
import model.tree.ParameterSelection;
import view.tree.CustomTreeNode;
import view.tree.Parameter;

public class CopyAction extends CustomAbstractAction {
	
	public CopyAction() {
		putValue(SMALL_ICON, loadIcon("/icons/copy20x20.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copies a parameter");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CustomTreeNode n = (CustomTreeNode)Core.getInstance().getTree().getLastSelectedPathComponent();
		if(n instanceof Parameter)
			copy((Parameter)n);
	}
	
	public void copy(Parameter parameter) {
		Core.getInstance().getClipboard().setContents(new ParameterSelection(parameter), Core.getInstance());
	}

}
