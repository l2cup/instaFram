package controller.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import javax.swing.SwingUtilities;

import exception_handler.ExceptionType;
import main.Core;
import view.tree.CustomTreeNode;

public class DeleteNodeAction extends CustomAbstractAction {
	
	private ArrayDeque<CustomTreeNode> deletedNodesDeque; 

	public DeleteNodeAction() {
		putValue(SMALL_ICON, loadIcon("/icons/delete20x20.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete Node");
		deletedNodesDeque = new ArrayDeque<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		Object p = Core.getInstance().getTree().getLastSelectedPathComponent();
		if (p!=null && p instanceof CustomTreeNode) {
			deleteNode((CustomTreeNode)p);
			Core.getInstance().getActionManager().getUndoAction().getUndoActionsDeque().push(this);
		}
		else {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.CHECK_NODE,null);
		}
		
		

	}
	
	
	public void deleteNode(CustomTreeNode n) {
		
		if(!Core.getInstance().getLoginSystem().getCurrentUser().isAdmin()) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.NOT_ADMIN, null);
			return;
		}
		
		CustomTreeNode parent = (CustomTreeNode) n.getParent();
		if(parent!=null) {
			deletedNodesDeque.push(n);
			parent.remove(n);
			System.out.println(deletedNodesDeque.peek());
		}
		SwingUtilities.updateComponentTreeUI(Core.getInstance().getTree());
	}
	
	public ArrayDeque<CustomTreeNode> getDeletedNodesDeque() {
		return deletedNodesDeque;
	}
}
