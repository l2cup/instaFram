package model.tree;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import view.tree.CustomTreeNode;

public class CustomTreeModel extends DefaultTreeModel {

	public CustomTreeModel() {
		super(new CustomTreeNode("Software Company"));
	}

	public void addNode(CustomTreeNode node) {
		((CustomTreeNode) getRoot()).addNode(node);
	}

	@Override
	public void setRoot(TreeNode root) {
		super.setRoot(root);
	}

}
