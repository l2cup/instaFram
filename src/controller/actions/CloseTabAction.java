package controller.actions;

import java.awt.event.ActionEvent;

import main.Core;
import view.midlevel.CustomTabbedPane;
import view.tree.CustomTreeNode;

public class CloseTabAction extends CustomAbstractAction {

	public CloseTabAction() {
		putValue(SMALL_ICON, loadIcon("/icons/close_tab20x20.png"));
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Closes tab");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index;
		CustomTabbedPane tabbedPane = Core.getInstance().getCustomTabbedPane();
		index = tabbedPane.getSelectedIndex();
		if (tabbedPane.getTabCount() != 0
				&& tabbedPane.getNodes().get(index).equals(Core.getInstance().getSelectedNode())) {
			Core.getInstance()
					.setSelectedNode((CustomTreeNode) Core.getInstance().getTree().getLastSelectedPathComponent());
			tabbedPane.getNodes().remove(index);
			tabbedPane.remove(index);
		}
	}

}
