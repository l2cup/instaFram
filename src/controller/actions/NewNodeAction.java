package controller.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.SwingUtilities;

import exception_handler.ExceptionType;
import main.Core;
import model.tree.ModuleModel;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;
import view.tree.Product;

public class NewNodeAction extends CustomAbstractAction {

	private ArrayDeque<CustomTreeNode> newNodesDeque;

	public NewNodeAction() {
		putValue(SMALL_ICON, loadIcon("/icons/new20x20.png"));
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "New Node");
		newNodesDeque = new ArrayDeque<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object n = Core.getInstance().getTree().getLastSelectedPathComponent();

		newNode((CustomTreeNode) n, null);

		
	}

	public void newNode(CustomTreeNode n, CustomTreeNode optional) {
		
		if (!Core.getInstance().getLoginSystem().getCurrentUser().isAdmin()) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.NOT_ADMIN, null);
			return;
		}

		if (n == null) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.CHECK_NODE, null);
			return;
		}

		if (n instanceof Product) {
			Module m = optional != null ? (Module) optional : new Module("@arg1");
			((Product) n).addNode(m);
			newNodesDeque.push(m);
		}

		else if (n instanceof Module) {
			Parameter p = optional != null ? (Parameter) optional : new Parameter("@arg1");
			((Module) n).addNode(p);
			newNodesDeque.push(p);
		}

		else if (n instanceof Parameter) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.NODE_PARAM, null);
		}

		else {
			Product p = optional != null ? (Product) optional : new Product("@arg1");
			((CustomTreeNode) n).add(p);
			newNodesDeque.push(p);
		}
		
		Core.getInstance().getActionManager().getUndoAction().getUndoActionsDeque().push(this);
		SwingUtilities.updateComponentTreeUI(Core.getInstance().getTree());
	}

	public ArrayDeque<CustomTreeNode> getNewNodesDeque() {
		return newNodesDeque;
	}

}
