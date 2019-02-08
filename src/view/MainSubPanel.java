package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import view.midlevel.HorizontalSplitPane;

public class MainSubPanel extends JPanel {

	private MainToolBar toolBar;
	private EtchedBorder border;
	private HorizontalSplitPane holderPanel;
	private GridBagConstraints c;

	public MainSubPanel(MainToolBar mtb, HorizontalSplitPane splitPane) {
		toolBar = mtb;
		holderPanel = splitPane;
		border = new EtchedBorder(EtchedBorder.LOWERED);
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		add(toolBar, c);
		c.gridy = 1;
		c.weighty = 1;
		add(holderPanel, c);
		setBorder(border);

	}

	public void setLayout() {
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		add(toolBar, c);
		c.gridy = 1;
		c.weighty = 1;
		add(holderPanel, c);
		setBorder(border);
	}

	public MainToolBar getToolBar() {
		return toolBar;
	}

	public HorizontalSplitPane getHolderPanel() {
		return holderPanel;
	}

}
