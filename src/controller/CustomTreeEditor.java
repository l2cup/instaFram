package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import main.Core;
import view.midlevel.CustomTabbedPane;
import view.tree.CustomTreeNode;

public class CustomTreeEditor extends DefaultTreeCellEditor implements ActionListener {

	private Object object = null;
	private JTextField tf = null;

	public CustomTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		object = value;
		tf = new JTextField(value.toString());
		tf.addActionListener(this);
		return tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (object instanceof CustomTreeNode) {
			String name = e.getActionCommand();
			((CustomTreeNode) object).setName(name);
			CustomTabbedPane ctp = Core.getInstance().getCustomTabbedPane();
			int index = ctp.getNodes().indexOf(object);
			if (index >= 0) {
				ctp.getNodes().get(index).setName(name);
				ctp.setTitleAt(index, name);
			}
		}
	}
}
