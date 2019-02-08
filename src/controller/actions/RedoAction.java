package controller.actions;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.util.ArrayDeque;

import javax.activation.ActivationDataFlavor;

import main.Core;
import model.tree.ParameterSelection;
import view.tree.CustomTreeNode;
import view.tree.Parameter;

public class RedoAction extends CustomAbstractAction {

	private ArrayDeque<CustomAbstractAction> redoActionDeque;
	
	public RedoAction() {
		putValue(SMALL_ICON, loadIcon("/icons/undo20x20.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redos an action");
		redoActionDeque = new ArrayDeque<>();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(redoActionDeque.isEmpty())
			return;
		
		CustomAbstractAction action = redoActionDeque.pop();
		Core.getInstance().getActionManager().getUndoAction().getUndoActionsDeque().push(action);
		
		if(action instanceof NewNodeAction)
			redoNewNode();
		else if(action instanceof DeleteNodeAction)
			redoDeleteNode();
		else if(action instanceof CutAction)
			redoCut();

	}
	
	private void redoDeleteNode() {
		
		CustomTreeNode node = Core.getInstance().getActionManager().getNewNodeAction().getNewNodesDeque().pop();
		Core.getInstance().getActionManager().getDeleteNodeAction().deleteNode(node);
		
	}

	private void redoNewNode() {
		
		CustomTreeNode node = Core.getInstance().getActionManager().getDeleteNodeAction().getDeletedNodesDeque().pop();
		Core.getInstance().getActionManager().getNewNodeAction().newNode((CustomTreeNode)node.getParent(), node);
		
	}
	
	private void redoCut() {
		Core.getInstance().getClipboard().setContents(new ParameterSelection((Parameter)Core.getInstance().getActionManager().getNewNodeAction().getNewNodesDeque().peek()), Core.getInstance());
		redoDeleteNode();
	}
	
	public ArrayDeque<CustomAbstractAction> getRedoActionDeque() {
		return redoActionDeque;
	}
}
