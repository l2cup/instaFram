package view.list;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import view.dynamic.custom.CustomPreviewPanel;

public class ListViewPanel extends JPanel {

	private JList<String> list;
	private JButton btnRemove;
	private GridBagConstraints c;
	private JScrollPane scrollPane;
	private DefaultListModel<String> model;

	public ListViewPanel(CustomPreviewPanel panel, int arg) {
		initPane(panel, arg);
	}

	private void initPane(CustomPreviewPanel panel, int arg) {
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeItem(panel, arg);

			}
		});
		model = new DefaultListModel<>();
		list = new JList<>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		initList(panel, arg);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, c);
		c.gridy = 1;
		c.weighty = 0;
		add(btnRemove, c);
		setVisible(true);
	}

	private void initList(CustomPreviewPanel panel, int arg) {
		String[] array = null;
		if (arg == 1) {
			array = new String[panel.getTextFieldMap().size()];
			panel.getTextFieldMap().keySet().toArray(array);
		} else if (arg == 2) {
			array = new String[panel.getCheckBoxMap().size()];
			panel.getCheckBoxMap().keySet().toArray(array);
		} else if (arg == 3) {
			Set<String> set = new TreeSet<>(panel.getLabelMap().keySet());
			set.removeAll(panel.getTextFieldMap().keySet());
			array = new String[set.size()];
			set.toArray(array);
		} else
			return;
		for (String string : array)
			model.addElement(string);

		list.revalidate();
		list.repaint();
	}

	public void removeItem(CustomPreviewPanel panel, int arg) {
		if (list.getSelectedIndex() > -1) {
			String key = model.remove(list.getSelectedIndex());
			if (arg == 1)
				panel.removeTextField(key);
			else if (arg == 2)
				panel.removeCheckBox(key);
			else if(arg == 3)
				panel.removeLabel(key);
			else
				return;
			list.revalidate();
			list.repaint();
			revalidate();
			repaint();
		}
	}

}
