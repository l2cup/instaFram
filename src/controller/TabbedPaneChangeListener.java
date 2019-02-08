package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.Core;
import view.midlevel.CustomTabbedPane;

public class TabbedPaneChangeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof CustomTabbedPane) {
			CustomTabbedPane ctp = (CustomTabbedPane) e.getSource();
			if (ctp.getSelectedIndex() != -1) {
				Core.getInstance().setSelectedNode(ctp.getNodes().get(ctp.getSelectedIndex()));

			}
		}
	}

}
