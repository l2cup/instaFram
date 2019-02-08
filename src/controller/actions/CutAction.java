package controller.actions;

import java.awt.event.ActionEvent;
import java.io.PushbackInputStream;

import main.Core;
import view.tree.CustomTreeNode;
import view.tree.Parameter;

public class CutAction extends CustomAbstractAction {

	public CutAction() {
		putValue(SMALL_ICON, loadIcon("/icons/cut20x20.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cuts a parameter");
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CustomTreeNode n = (CustomTreeNode)Core.getInstance().getTree().getLastSelectedPathComponent();
		if(n instanceof Parameter) {
			cut((Parameter)n);
			Core.getInstance().getActionManager().getUndoAction().getUndoActionsDeque().push(this);
		}
	}
	
	public void cut(Parameter p) {
		Core.getInstance().getActionManager().getCopyAction().copy(p);
		Core.getInstance().getActionManager().getDeleteNodeAction().deleteNode(p);
	}

}
