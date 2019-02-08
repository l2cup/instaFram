package view.midlevel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BottomVerticalPane extends JPanel {

	private JLabel lbLeafs, lbParent, lbName, lbChildren;
	private JTextArea txtContent;
	private GridBagConstraints c;

	public BottomVerticalPane() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		init();
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		add(lbName, c);
		c.gridy = 1;
		add(lbParent, c);
		c.gridy = 2;
		add(lbLeafs, c);
		c.gridy = 3;
		add(lbChildren, c);
		c.weighty = 1;
		c.gridy = 4;
		add(txtContent, c);
	}

	private void init() {
		lbLeafs = new JLabel("Leaf count: ");
		lbLeafs.setToolTipText("Number of leaves.");
		lbParent = new JLabel("Parent: ");
		lbParent.setToolTipText("Parent of node.");
		lbName = new JLabel("Name: ");
		lbName.setToolTipText("Name of node.");
		lbChildren = new JLabel("Children count: ");
		lbChildren.setToolTipText("Number of direct children this node has.");
		txtContent = new JTextArea();
		txtContent.setWrapStyleWord(true);
		txtContent.setEditable(false);
		txtContent.setLineWrap(true);
	}

	public JLabel getLbLeafs() {
		return lbLeafs;
	}

	public JLabel getLbParent() {
		return lbParent;
	}

	public JLabel getLbName() {
		return lbName;
	}

	public JLabel getLbChildren() {
		return lbChildren;
	}

	public JTextArea getTxtContent() {
		return txtContent;
	}

	public void setLbLeafs(JLabel lbLeafs) {
		this.lbLeafs = lbLeafs;
	}

	public void setLbParent(JLabel lbParent) {
		this.lbParent = lbParent;
	}

	public void setLbName(JLabel lbName) {
		this.lbName = lbName;
	}

	public void setLbChildren(JLabel lbChildren) {
		this.lbChildren = lbChildren;
	}

	public void setTxtContent(JTextArea txtContent) {
		this.txtContent = txtContent;
	}
}
