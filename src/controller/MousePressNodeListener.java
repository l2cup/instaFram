package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.Core;
import view.midlevel.CustomTabbedPane;
import view.tree.CustomTreeNode;

public class MousePressNodeListener extends MouseAdapter {

	private CustomTreeNode nodePressed = null;
	private CustomTabbedPane tabbedPane = null;

	@Override
	public void mouseClicked(MouseEvent e) {
		nodePressed = (CustomTreeNode) Core.getInstance().getTree().getLastSelectedPathComponent();
		tabbedPane = Core.getInstance().getCustomTabbedPane();
		if (e.getClickCount() == 2) {
			if (Core.getInstance().getTree().getRowForLocation(e.getX(), e.getY()) != -1) {
				tabbedPane.openTab(nodePressed);
				Core.getInstance().setSelectedNode(nodePressed);
			}
			else
				Core.getInstance().getTree().clearSelection();
		}
		if (e.getClickCount() == 1) {
			if (Core.getInstance().getTree().getRowForLocation(e.getX(), e.getY()) != -1)
				Core.getInstance().setSelectedNode(nodePressed);
			else
				Core.getInstance().getTree().clearSelection();
		}

	}

}
