package view.midlevel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import view.tree.CustomTree;

public class TreePanel extends JPanel {

	private CustomTree tree;
	private GridBagConstraints c;

	public TreePanel(CustomTree tree) {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		this.tree = tree;
		add(tree, c);
	}
}
