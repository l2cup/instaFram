package view.tree;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import controller.CustomTreeEditor;
import main.Core;
import model.tree.CustomTreeModel;

public class CustomTree extends JTree {

	public CustomTree() {
		setEditable(true);
		setModel(new CustomTreeModel());
		setCellEditor(new CustomTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new CustomTreeCellRenderer());
		addMouseListener(Core.getInstance().getActionManager().getMousePressNodeListener());
	}

	public void addNode(CustomTreeNode node) {
		((CustomTreeNode) getModel().getRoot()).addNode(node);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
