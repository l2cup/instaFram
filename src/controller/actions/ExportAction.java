package controller.actions;

import java.awt.event.ActionEvent;

import main.Core;
import view.export.ExportFrame;
import view.tree.Product;

public class ExportAction extends CustomAbstractAction {
	
	public ExportAction() {
		putValue(SMALL_ICON, loadIcon("/icons/export20x20.png"));
		putValue(NAME, "Export");
		putValue(SHORT_DESCRIPTION, "Export an installer");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Core.getInstance().getSelectedNode() instanceof Product) {
			Product product = (Product)Core.getInstance().getSelectedNode();
			if(Core.getInstance().getPathChecker().arePathsFilled(product))
				Core.getInstance().getModulesDialog().showDialog(product);
		}
	}

}
