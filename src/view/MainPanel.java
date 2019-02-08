package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9203835972233275989L;

	private MainSubPanel mainSubPanel;
	private GridBagConstraints c;
	private EtchedBorder etchedBorder;
	private StatusBar statusBar;

	public MainPanel(MainSubPanel msp, StatusBar sb) {
		c = new GridBagConstraints();
		mainSubPanel = msp;
		statusBar = sb;
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(mainSubPanel, c);
		c.gridy = 1;
		c.weighty = 0;
		add(statusBar, c);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.DARK_GRAY));

	}

	public MainSubPanel getMainSubPanel() {
		return mainSubPanel;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

}
