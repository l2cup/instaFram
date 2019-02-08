package view.midlevel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class RightHorizontalPane extends JPanel {

	private TabToolBar toolBar;
	private CustomTabbedPane customTabbedPane;
	private GridBagConstraints bagConstraints;

	public RightHorizontalPane(CustomTabbedPane ctp, TabToolBar mtb) {
		setLayout(new GridBagLayout());
		bagConstraints = new GridBagConstraints();
		toolBar = new TabToolBar();
		customTabbedPane = ctp;
		bagConstraints.fill = GridBagConstraints.BOTH;
		bagConstraints.weightx = 1;
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.anchor = GridBagConstraints.PAGE_START;
		add(toolBar, bagConstraints);
		bagConstraints.gridy = 1;
		bagConstraints.weighty = 1;
		add(customTabbedPane, bagConstraints);

		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.darkGray));
	}
}
