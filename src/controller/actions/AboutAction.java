package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import main.Core;

public class AboutAction extends CustomAbstractAction {

	public AboutAction() {

		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "Opens about window");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(Core.getInstance().getMainFrame(), "Uros Nikolic\nRN-21/2017\nl2cup", "About",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
