package controller.actions;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import main.Core;
import model.tree.ParameterSelection;
import model.tree.ParameterType;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;

public class PasteAction extends CustomAbstractAction {
	
	public PasteAction() {
		putValue(SMALL_ICON, loadIcon("/icons/paste20x20.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Pastes copied parameter");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Core.getInstance().getClipboard().getContents(this) != null) {
			try {
				paste((Parameter)Core.getInstance().getClipboard().getContents(this).getTransferData(ParameterSelection.parameterFlavor));
			} catch (UnsupportedFlavorException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void paste(Parameter parameter) {
		System.out.println(parameter.getName());
		if(Core.getInstance().getTree().getLastSelectedPathComponent() instanceof Module) {
			Parameter p = new Parameter(parameter.getName());
			p.setNodeModel(parameter.getNodeModel());
			p.setCustomPanel(parameter.getCustomPanel());
			Core.getInstance().getActionManager().getNewNodeAction().newNode((CustomTreeNode)Core.getInstance().getTree().getLastSelectedPathComponent(), p);
		}
	}

}
