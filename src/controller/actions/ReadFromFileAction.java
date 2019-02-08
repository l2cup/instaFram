package controller.actions;

import java.awt.event.ActionEvent;

import exception_handler.ExceptionType;
import main.Core;
import view.tree.Parameter;

public class ReadFromFileAction extends CustomAbstractAction {

	public ReadFromFileAction() {
		putValue(SMALL_ICON, loadIcon("/icons/open20x20.png"));
		putValue(NAME, "Read From File");
		putValue(SHORT_DESCRIPTION, "Read Tree From File");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!Core.getInstance().getLoginSystem().getCurrentUser().isAdmin()) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.NOT_ADMIN, null);
			return;
		}
		
		if (!(Core.getInstance().getSelectedNode() instanceof Parameter))
			Core.getInstance().getObjectReader().readObject(Core.getInstance().getSelectedNode());

	}

}
