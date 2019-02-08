package controller.actions;

import java.awt.event.ActionEvent;

import main.Core;

public class WriteToFileAction extends CustomAbstractAction {

	public WriteToFileAction() {
		putValue(SMALL_ICON, loadIcon("/icons/save20x20.png"));
		putValue(NAME, "Write To File");
		putValue(SHORT_DESCRIPTION, "Writes Tree to file");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Core.getInstance().getObjectWriter().writeObject(Core.getInstance().getSelectedNode());
	}
}
