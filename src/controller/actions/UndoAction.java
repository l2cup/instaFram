package controller.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayDeque;

import main.Core;
import model.tree.ParameterSelection;
import view.tree.CustomTreeNode;

public class UndoAction extends CustomAbstractAction {

	private ArrayDeque<CustomAbstractAction> undoActionsDeque;

	public UndoAction() {
		putValue(SMALL_ICON, loadIcon("/icons/redo20x20.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undoes an action");
		undoActionsDeque = new ArrayDeque<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(undoActionsDeque.isEmpty())
			return;
		
		CustomAbstractAction action = undoActionsDeque.pop();
		Core.getInstance().getActionManager().getRedoAction().getRedoActionDeque().push(action);
		
		if(action instanceof NewNodeAction && !Core.getInstance().getActionManager().getNewNodeAction().getNewNodesDeque().isEmpty())
			undoNewNode();
		else if(action instanceof DeleteNodeAction)
			undoDeleteNode();
		else if(action instanceof CutAction)
			undoCut();

	}

	private void undoNewNode() {
		CustomTreeNode node = Core.getInstance().getActionManager().getNewNodeAction().getNewNodesDeque().pop();
		Core.getInstance().getActionManager().getDeleteNodeAction().deleteNode(node);
	}

	private void undoDeleteNode() {
		CustomTreeNode node = Core.getInstance().getActionManager().getDeleteNodeAction().getDeletedNodesDeque().pop();
		Core.getInstance().getActionManager().getNewNodeAction().newNode((CustomTreeNode) node.getParent(), node);
	}

	public void undoCut() {
		undoDeleteNode();
		Core.getInstance().getClipboard().setContents(new ParameterSelection(null), Core.getInstance());
	}

	public ArrayDeque<CustomAbstractAction> getUndoActionsDeque() {
		return undoActionsDeque;
	}
}
