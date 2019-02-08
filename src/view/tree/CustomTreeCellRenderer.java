package view.tree;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

	public CustomTreeCellRenderer() {

	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		CustomTreeNode customTreeNode;
		if (value instanceof CustomTreeNode) {
			customTreeNode = (CustomTreeNode) value;

			if (!customTreeNode.isLeaf() || customTreeNode.getParent() == null) {
				URL imageURL = getClass().getResource("/icons/folder16x16.png");
				Icon icon = null;
				if (imageURL != null) {
					icon = new ImageIcon(imageURL);
				}
				setIcon(icon);
			} else {
				URL imageURL = getClass().getResource("/icons/file16x16.png");
				Icon icon = null;
				if (imageURL != null) {
					icon = new ImageIcon(imageURL);
				}
				setIcon(icon);
			}
		}

		return this;
	}
}
